

package com.lhtw.ais.messages;

import dk.tbsalling.aismessages.ais.messages.types.AISMessageType;
import dk.tbsalling.aismessages.ais.messages.types.PositionFixingDevice;
import dk.tbsalling.aismessages.ais.messages.types.SOTDMACommunicationState;
import dk.tbsalling.aismessages.nmea.messages.NMEAMessage;

import java.lang.ref.WeakReference;

import static dk.tbsalling.aismessages.ais.Decoders.BOOLEAN_DECODER;
import static dk.tbsalling.aismessages.ais.Decoders.FLOAT_DECODER;
import static dk.tbsalling.aismessages.ais.Decoders.UNSIGNED_INTEGER_DECODER;

/**
 * This message is to be used by fixed-location base stations to periodically report a position and time reference.
 * @author tbsalling
 *
 */
@SuppressWarnings("serial")
public class BaseStationReport extends AISMessage {

    public BaseStationReport(NMEAMessage[] nmeaMessages) {
        super(nmeaMessages);
    }

    protected BaseStationReport(NMEAMessage[] nmeaMessages, String bitString) {
        super(nmeaMessages, bitString);
    }

    protected void checkAISMessage() {
    }

    public final AISMessageType getMessageType() {
        return AISMessageType.BaseStationReport;
    }

    @SuppressWarnings("unused")
	public Integer getYear() {
        return getDecodedValue(() -> year, value -> year = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(38, 52)));
	}

    @SuppressWarnings("unused")
	public Integer getMonth() {
        return getDecodedValue(() -> month, value -> month = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(52, 56)));
	}

    @SuppressWarnings("unused")
	public Integer getDay() {
        return getDecodedValue(() -> day, value -> day = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(56, 61)));
	}

    @SuppressWarnings("unused")
	public Integer getHour() {
        return getDecodedValue(() -> hour, value -> hour = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(61, 66)));
	}

    @SuppressWarnings("unused")
	public Integer getMinute() {
        return getDecodedValue(() -> minute, value -> minute = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(66, 72)));
	}

    @SuppressWarnings("unused")
	public Integer getSecond() {
        return getDecodedValue(() -> second, value -> second = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(72, 78)));
	}

    @SuppressWarnings("unused")
	public Boolean getPositionAccurate() {
        return getDecodedValue(() -> positionAccurate, value -> positionAccurate = value, () -> Boolean.TRUE, () -> BOOLEAN_DECODER.apply(getBits(78, 79)));
	}

    @SuppressWarnings("unused")
	public Float getLatitude() {
        return getDecodedValue(() -> latitude, value -> latitude = value, () -> Boolean.TRUE, () -> FLOAT_DECODER.apply(getBits(107, 134)) / 600000f);
	}

    @SuppressWarnings("unused")
	public Float getLongitude() {
        return getDecodedValue(() -> longitude, value -> longitude = value, () -> Boolean.TRUE, () -> FLOAT_DECODER.apply(getBits(79, 107)) / 600000f);
	}

    @SuppressWarnings("unused")
	public PositionFixingDevice getPositionFixingDevice() {
        return getDecodedValue(() -> positionFixingDevice, value -> positionFixingDevice = value, () -> Boolean.TRUE, () -> PositionFixingDevice.fromInteger(UNSIGNED_INTEGER_DECODER.apply(getBits(134, 138))));
	}

    @SuppressWarnings("unused")
	public Boolean getRaimFlag() {
        return getDecodedValue(() -> raimFlag, value -> raimFlag = value, () -> Boolean.TRUE, () -> BOOLEAN_DECODER.apply(getBits(148, 149)));
	}

    @SuppressWarnings("unused")
    public SOTDMACommunicationState getCommunicationState() {
        return getDecodedValueByWeakReference(() -> communicationState, value -> communicationState = value, () -> Boolean.TRUE, () -> SOTDMACommunicationState.fromBitString(getBits(149, 168)));
    }

    @Override
    public String toString() {
        return "BaseStationReport{" +
                "messageType=" + getMessageType() +
                ", year=" + getYear() +
                ", month=" + getMonth() +
                ", day=" + getDay() +
                ", hour=" + getHour() +
                ", minute=" + getMinute() +
                ", second=" + getSecond() +
                ", positionAccurate=" + getPositionAccurate() +
                ", latitude=" + getLatitude() +
                ", longitude=" + getLongitude() +
                ", positionFixingDevice=" + getPositionFixingDevice() +
                ", raimFlag=" + getRaimFlag() +
                ", communicationState=" + getCommunicationState() +
                "} " + super.toString();
    }

    private transient Integer year;
    private transient Integer month;
    private transient Integer day;
    private transient Integer hour;
    private transient Integer minute;
    private transient Integer second;
    private transient Boolean positionAccurate;
    private transient Float latitude;
    private transient Float longitude;
    private transient PositionFixingDevice positionFixingDevice;
    private transient Boolean raimFlag;
    private transient WeakReference<SOTDMACommunicationState> communicationState;
}
