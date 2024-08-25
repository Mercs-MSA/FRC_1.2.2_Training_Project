// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

  /**
   * This program demonstrates a basic time-based robot employing a joystick and a single NEO motor.
   */

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

// We add this line to enable us to create a Digital Input object
import edu.wpi.first.wpilibj.DigitalInput;

// We add this line to enable us to create a Digital Output object
import edu.wpi.first.wpilibj.DigitalOutput;

// We add this line to enable us to create a Debouncer object
import edu.wpi.first.math.filter.Debouncer;

public class Robot extends TimedRobot {

  // We add this line to create a new instance of a Digital Input object at DIO port 0
  DigitalInput my_discrete_input0 = new DigitalInput(0);

  // We add this line to create a new instance of a Digital Output object at DIO port 1
  DigitalOutput my_discrete_output1 = new DigitalOutput(1);

  // We add this line to create a new instance of a Digital Output object at DIO port 2
  DigitalOutput my_discrete_output2 = new DigitalOutput(2);

  // We add this line to create a new instance of a Debouncer object
  Debouncer m_debouncer = new Debouncer(0.05, Debouncer.DebounceType.kBoth);

  // We add this line to create a couple of Boolean objects
  Boolean my_output, my_debounced_output;

  @Override
  public void robotInit() {

  }

  @Override
  public void robotPeriodic() {
    my_output = my_discrete_input0.get();   // Read the digital output directly
    my_debounced_output = m_debouncer.calculate(my_discrete_input0.get());  // Read the same input, but filter it

    my_discrete_output1.set(!my_output);
    my_discrete_output2.set(!my_debounced_output);
  }
}