package com.mtn.messages;

import com.mtn.entity.StandardSensorEntity;

/**
 * @author Mahdi
 */
public class MagneticFieldMessage extends SensorMessage {
    public MagneticFieldMessage(StandardSensorEntity entity, long time) {
        super(entity, time);
    }
}
