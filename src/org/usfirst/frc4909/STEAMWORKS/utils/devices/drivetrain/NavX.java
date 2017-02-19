package org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI.Port;

public class NavX extends AHRS {

	public NavX(Port spi_port_id) {
		super(spi_port_id);
		// TODO Auto-generated constructor stub
	}

	public NavX(edu.wpi.first.wpilibj.I2C.Port i2c_port_id) {
		super(i2c_port_id);
		// TODO Auto-generated constructor stub
	}

	public NavX(edu.wpi.first.wpilibj.SerialPort.Port serial_port_id) {
		super(serial_port_id);
		// TODO Auto-generated constructor stub
	}

	public NavX(Port spi_port_id, byte update_rate_hz) {
		super(spi_port_id, update_rate_hz);
		// TODO Auto-generated constructor stub
	}

	public NavX(edu.wpi.first.wpilibj.I2C.Port i2c_port_id, byte update_rate_hz) {
		super(i2c_port_id, update_rate_hz);
		// TODO Auto-generated constructor stub
	}

	public NavX(Port spi_port_id, int spi_bitrate, byte update_rate_hz) {
		super(spi_port_id, spi_bitrate, update_rate_hz);
		// TODO Auto-generated constructor stub
	}

	public NavX(edu.wpi.first.wpilibj.SerialPort.Port serial_port_id, SerialDataType data_type, byte update_rate_hz) {
		super(serial_port_id, data_type, update_rate_hz);
		// TODO Auto-generated constructor stub
	}

}
