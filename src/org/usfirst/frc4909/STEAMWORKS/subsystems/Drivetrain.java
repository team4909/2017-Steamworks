package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.*;
import org.usfirst.frc4909.STEAMWORKS.utils.DrivetrainSubsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

public class Drivetrain extends DrivetrainSubsystem {
	//in inches
	private double wheelDiameter = 4.0;
	private double pulsesPerRev = 1440.0;
    
    private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    
    private final DoubleSolenoid shiftSolenoid = RobotMap.shiftSolenoid;
    
    private final double ENCODER_CONSTANT = 3.0;
   
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

	public RobotDrive getRobotDrive() {
		return RobotMap.drivetrainRobotDrive;
	}
	
	public AHRS getNavX(){
    	return RobotMap.navx;
    }

    public double getLeftEncDistance(){
    	return ENCODER_CONSTANT*(leftEncoder.getRaw()/pulsesPerRev)*(Math.PI*wheelDiameter);
    }
    
    public double getRightEncDistance(){
    	return ENCODER_CONSTANT*(rightEncoder.getRaw()/pulsesPerRev)*(Math.PI*wheelDiameter);
    }
    
    public void shift(){
    	if(shiftSolenoid.get()==Value.kForward)
        	shiftSolenoid.set(Value.kReverse);
    	else
        	shiftSolenoid.set(Value.kForward);
    }
    
    /*** Work on Moving Everything Below this into the Shared Drivetrain Code, After Being Tested***/

	private double navP = 0.0002;
	private double navI = 0.00000;
	private double navD = 0.00000;
	private final PIDController navxPID = new PIDController(navP, navI, navD,.6);
    
    private double encP = 0.15;
	private double encI = 0.00000;
	private double encD = 0.00000;
    private final PIDController encPID = new PIDController(encP, encI, encD,.8);
    
    public double getDisplacementX(){
    	return this.getNavX().getDisplacementX()*39.37007874;
    }
    
    public double getDisplacementY(){
    	return this.getNavX().getDisplacementY()*39.37007874;
    }
    
    public double getDisplacementZ(){
    	return this.getNavX().getDisplacementZ()*39.37007874;
    }
    
    /**
     * 
     * @param dist Distance in inches
     */
    public void driveStraightNavX(double dist){
    	navxPID.resetPID();
    	this.getNavX().resetDisplacement();
    	SmartDashboard.putNumber("nP", navP);
    	SmartDashboard.putNumber("nI", navI);
    	SmartDashboard.putNumber("nD", navD);

    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		navxPID.atTarget=false;
        	navP=SmartDashboard.getNumber("nP", 0);
        	navI=SmartDashboard.getNumber("nI", 0);
        	navD=SmartDashboard.getNumber("nD", 0);
        	navxPID.changePIDGains(navP, navI, navD);

    		double currentDist=getDisplacementY();
    		SmartDashboard.putNumber("current dist",currentDist);
    		SmartDashboard.putNumber("nPID out",navxPID.calcPID(dist, currentDist, .05));

    		this.getRobotDrive().arcadeDrive(-navxPID.calcPID(dist, currentDist, .05),0);
    		if(!navxPID.isDone())
    			targetTime=Timer.getFPGATimestamp();
    	}
    	
    	SmartDashboard.putBoolean("straightNav", false);
    }
    
    public void driveStraight(double target, double leftDistance, double rightDistance, double threshold){
		this.getRobotDrive().tankDrive(encPID.calcPID(target, leftDistance, threshold),encPID.calcPID(target, rightDistance, threshold));
	}
    
    /**
     * 
     * @param dist Distance in inches
     */
    public void driveStraightEncoder(double dist){
    	encPID.resetPID();
    	leftEncoder.reset();
    	rightEncoder.reset();
    	
    	SmartDashboard.putBoolean("straightEnc", true);
    	SmartDashboard.putNumber("eP", encP);
    	SmartDashboard.putNumber("eI", encI);
    	SmartDashboard.putNumber("eD", encD);
    	
    	double maxP=0;
    	double LPower=0;
    	double RPower=0;
    	
    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		maxP+=.005;
    		encPID.atTarget=false;
        	encP=SmartDashboard.getNumber("eP", 0);
        	encI=SmartDashboard.getNumber("eI", 0);
        	encD=SmartDashboard.getNumber("eD", 0);
        	encPID.changePIDGains(encP, encI, encD);

    		double currentDistL=getLeftEncDistance();
    		double currentDistR=getRightEncDistance();

    		SmartDashboard.putNumber("current distance",currentDistL);
    		SmartDashboard.putNumber("current distance",currentDistR);

    		LPower=-encPID.calcPID(dist, currentDistL, 2);
    		RPower=-encPID.calcPID(dist, currentDistR, 2);
    		if(Math.abs(LPower)>maxP)
    			LPower=maxP*Math.signum(LPower);
    		if(Math.abs(RPower)>maxP)
    			RPower=maxP*Math.signum(RPower);
    		
    		SmartDashboard.putNumber("encPID L out",LPower);
    		SmartDashboard.putNumber("encPID R out",RPower);

    		this.getRobotDrive().tankDrive(LPower,RPower*.95);
    		
    		if(!encPID.isDone())
    			targetTime=Timer.getFPGATimestamp();
    	}
    	
    	SmartDashboard.putBoolean("straightEnc", false);
    }
    
    /**
     * 
     * @param dist Distance in inches
     */
    public void driveUnevenEncoder(double dist){
    	encPID.resetPID();
    	leftEncoder.reset();
    	rightEncoder.reset();

    	SmartDashboard.putNumber("eP", encP);
    	SmartDashboard.putNumber("eI", encI);
    	SmartDashboard.putNumber("eD", encD);

    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		encPID.atTarget=false;
        	encP=SmartDashboard.getNumber("eP", 0);
        	encI=SmartDashboard.getNumber("eI", 0);
        	encD=SmartDashboard.getNumber("eD", 0);
        	encPID.changePIDGains(encP, encI, encD);

    		double currentDist=0;
    		SmartDashboard.putNumber("current dist",currentDist);
    		SmartDashboard.putNumber("nPID out",encPID.calcPID(dist, currentDist, .05));

    		this.getRobotDrive().arcadeDrive(-encPID.calcPID(dist, currentDist, .05),0);
    		if(!encPID.isDone())
   				targetTime=Timer.getFPGATimestamp();
    	}
    	
    	SmartDashboard.putBoolean("straight", false);
    }
}