package mainPKG;

import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.SampleProvider;
//import lejos.robotics.chassis.Chassis;
//import lejos.robotics.chassis.Wheel;
//import lejos.robotics.chassis.WheeledChassis;
//import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;

public class Main {
	
	static final int DETECTOR_DELAY = 1000;
	
	static EV3IRSensor irS1 = new EV3IRSensor(SensorPort.S1);
	static EV3IRSensor irS2 = new EV3IRSensor(SensorPort.S2);
	static EV3IRSensor irS3 = new EV3IRSensor(SensorPort.S3);
	static EV3IRSensor irS4 = new EV3IRSensor(SensorPort.S4);
	
	//static Wheel wheel1 = WheeledChassis.modelWheel(Motor.B, 4.185).
	//		offset(-3.4553).invert(true);
	//static Wheel wheel2 = WheeledChassis.modelWheel(Motor.C, 4.185).
	//		offset(3.4553).invert(true);
	//static Chassis chassis = new WheeledChassis(new Wheel[] {
	//		wheel1, wheel2}, WheeledChassis.TYPE_DIFFERENTIAL
	//);
	//static MovePilot pilot = new MovePilot(chassis);
	
	static SampleProvider distance1 = irS1.getDistanceMode();
	static SampleProvider distance2 = irS2.getDistanceMode();
	static SampleProvider distance3 = irS3.getDistanceMode();
	static SampleProvider distance4 = irS4.getDistanceMode();
	
	static float[] distances1 = new float[distance1.sampleSize()];
	static float[] distances2 = new float[distance2.sampleSize()];
	static float[] distances3 = new float[distance3.sampleSize()];
	static float[] distances4 = new float[distance4.sampleSize()];
	
	public static void main(String[] args) throws InterruptedException {
		algoOne();
		Delay.msDelay(DETECTOR_DELAY);
	}

	public static void rotate(double rotation) {
		//pilot.rotate(rotation);
	}
	
	public static void move(double distance) {
		//pilot.travel(distance);
	}

	public static void algoOne() {
		while(true) {
			distance1.fetchSample(distances1, 0);
			distance2.fetchSample(distances2, 0);
			distance3.fetchSample(distances3, 0);
			distance4.fetchSample(distances4, 0);
			if(distances1[0] > 0.5) {
				if(distances1[0] < 0.5) {Motor.B.stop(); Motor.B.stop();}
				Motor.B.backward();
				Motor.C.backward();
				//pilot.forward();
			} else if(distances2[0] > 0.5) {
				if(distances2[0] < 0.5) {Motor.B.stop(); Motor.B.stop();}
				Motor.B.backward();
				Motor.C.backward();
				//pilot.forward();
			} else if(distances3[0] > 0.5) {
				if(distances3[0] < 0.5) {Motor.B.stop(); Motor.B.stop();}
				Motor.B.backward();
				Motor.C.backward();
				//pilot.forward();
			} else if(distances4[0] > 0.5) {
				if(distances4[0] < 0.5) {Motor.B.stop(); Motor.B.stop();}
				Motor.B.backward();
				Motor.C.backward();
				//pilot.forward();
			}
			System.out.println(distances1[0]);
			System.out.println(distances2[0]);
			System.out.println(distances3[0]);
			System.out.println(distances4[0]);
		}
	}
}
