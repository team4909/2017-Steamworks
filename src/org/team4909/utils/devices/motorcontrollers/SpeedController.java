package org.team4909.utils.devices.motorcontrollers;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;

public class SpeedController implements edu.wpi.first.wpilibj.SpeedController, LiveWindowSendable {
	protected final edu.wpi.first.wpilibj.SpeedController speedController;
	
	private ArrayList<SlaveSpeedController> slaveMotors = new ArrayList<SlaveSpeedController>();
	
	public SpeedController(edu.wpi.first.wpilibj.SpeedController initSpeedController) {
		speedController = initSpeedController;
	}

	public void pidWrite(double output) {
		speedController.pidWrite(output);
		
		for (int i = 0; i < slaveMotors.size(); i++) {
			SlaveSpeedController slave = slaveMotors.get(i);
			
			slave.pidWrite(output);
		}
	}

	public double get() {
		return speedController.get();
	}

	public void set(double speed) {
		speedController.set(speed);
		
		for (int i = 0; i < slaveMotors.size(); i++) {
			SlaveSpeedController slave = slaveMotors.get(i);
			
			slave.set(speed);
		}
	}

	public void setInverted(boolean isInverted) {
		speedController.setInverted(isInverted);
		
		for (int i = 0; i < slaveMotors.size(); i++) {
			SlaveSpeedController slave = slaveMotors.get(i);
			
			slave.setInverted(isInverted);
		}
	}

	public boolean getInverted() {
		return speedController.getInverted();
	}

	public void disable() {
		speedController.disable();
		
		for (int i = 0; i < slaveMotors.size(); i++) {
			SlaveSpeedController slave = slaveMotors.get(i);
			
			slave.disable();
		}
	}

	public void stopMotor() {
		speedController.stopMotor();
		
		for (int i = 0; i < slaveMotors.size(); i++) {
			SlaveSpeedController slave = slaveMotors.get(i);
			
			slave.stopMotor();
		}
	}
	
	public SlaveSpeedController addSlaveMotor(edu.wpi.first.wpilibj.SpeedController initMotor, double multiplier){
		SlaveSpeedController motor = new SlaveSpeedController(initMotor, multiplier);
		
		slaveMotors.add(motor);
		
		return motor;
	}

	@Override
	public void initTable(ITable subtable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ITable getTable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSmartDashboardType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startLiveWindowMode() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopLiveWindowMode() {
		// TODO Auto-generated method stub
		
	}
}
