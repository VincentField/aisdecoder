

package com.lhtw.ais.messages;

import dk.tbsalling.aismessages.ais.messages.types.AISMessageType;
import dk.tbsalling.aismessages.ais.messages.types.MMSI;
import dk.tbsalling.aismessages.ais.messages.types.PositionFixingDevice;
import dk.tbsalling.aismessages.ais.messages.types.ShipType;
import dk.tbsalling.aismessages.ais.messages.types.TransponderClass;
import dk.tbsalling.aismessages.nmea.messages.NMEAMessage;

import static dk.tbsalling.aismessages.ais.Decoders.STRING_DECODER;
import static dk.tbsalling.aismessages.ais.Decoders.UNSIGNED_INTEGER_DECODER;

@SuppressWarnings("serial")
public class ClassBCSStaticDataReport extends AISMessage implements StaticDataReport {

    public ClassBCSStaticDataReport(NMEAMessage[] nmeaMessages) {
        super(nmeaMessages);
    }

    protected ClassBCSStaticDataReport(NMEAMessage[] nmeaMessages, String bitString) {
        super(nmeaMessages, bitString);
    }

    protected void checkAISMessage() {
    }

    public final AISMessageType getMessageType() {
        return AISMessageType.ClassBCSStaticDataReport;
    }

    @Override
    public TransponderClass getTransponderClass() {
        return TransponderClass.B;
    }

    @SuppressWarnings("unused")
	public Integer getPartNumber() {
        return getDecodedValue(() -> partNumber, value -> partNumber = value, () -> Boolean.TRUE, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(38, 40)));
	}

    @SuppressWarnings("unused")
	public String getShipName() {
        return getDecodedValue(() -> shipName, value -> shipName = value, () -> getPartNumber() == 0, () -> STRING_DECODER.apply(getBits(40, 160)));
	}

    @SuppressWarnings("unused")
	public ShipType getShipType() {
        return getDecodedValue(() -> shipType, value -> shipType = value, () -> getPartNumber() == 1, () -> ShipType.fromInteger(UNSIGNED_INTEGER_DECODER.apply(getBits(40, 48))));
	}

    @SuppressWarnings("unused")
	public String getVendorId() {
        return getDecodedValue(() -> vendorId, value -> vendorId = value, () -> getPartNumber() == 1, () -> STRING_DECODER.apply(getBits(48, 90)));
	}

    @SuppressWarnings("unused")
	public String getCallsign() {
        return getDecodedValue(() -> callsign, value -> callsign = value, () -> getPartNumber() == 1, () -> STRING_DECODER.apply(getBits(90, 132)));
	}

    @SuppressWarnings("unused")
	public Integer getToBow() {
        return getDecodedValue(() -> toBow, value -> toBow = value, () -> getPartNumber() == 1, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(132, 141)));
	}

    @SuppressWarnings("unused")
	public Integer getToStern() {
        return getDecodedValue(() -> toStern, value -> toStern = value, () -> getPartNumber() == 1, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(141, 150)));
	}

    @SuppressWarnings("unused")
	public Integer getToStarboard() {
        return getDecodedValue(() -> toStarboard, value -> toStarboard = value, () -> getPartNumber() == 1, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(156, 162)));
	}

    @SuppressWarnings("unused")
	public Integer getToPort() {
        return getDecodedValue(() -> toPort, value -> toPort = value, () -> getPartNumber() == 1, () -> UNSIGNED_INTEGER_DECODER.apply(getBits(150, 156)));
	}

//    @SuppressWarnings("unused")
//	public MMSI getMothershipMmsi() {
//        return getDecodedValue(() -> mothershipMmsi, value -> mothershipMmsi = value, () -> getPartNumber() == 1, () -> MMSI.valueOf(UNSIGNED_INTEGER_DECODER.apply(getBits(132, 162))));
//	}
    @SuppressWarnings("unused")
	public PositionFixingDevice getPositionFixingDevice() {
        return getDecodedValue(() -> positionFixingDevice, value -> positionFixingDevice = value, () -> Boolean.TRUE, () -> PositionFixingDevice.fromInteger(UNSIGNED_INTEGER_DECODER.apply(getBits(162, 166))));
	}

    @Override
    public String toString() {
        return "ClassBCSStaticDataReport{" +
                "messageType=" + getMessageType() +
                ", partNumber=" + getPartNumber() +
                ", shipName='" + getShipName() + '\'' +
                ", shipType=" + getShipType() +
                ", vendorId='" + getVendorId() + '\'' +
                ", callsign='" + getCallsign() + '\'' +
                ", toBow=" + getToBow() +
                ", toStern=" + getToStern() +
                ", toStarboard=" + getToStarboard() +
                ", toPort=" + getToPort() +
                ", positionFixingDevice=" + getPositionFixingDevice() +
                "} " + super.toString();
    }

    private transient Integer partNumber;
    private transient String shipName;
    private transient ShipType shipType;
    private transient String vendorId;
    private transient String callsign;
    private transient Integer toBow;
    private transient Integer toStern;
    private transient Integer toStarboard;
    private transient Integer toPort;
//    private transient MMSI mothershipMmsi;
    private transient PositionFixingDevice positionFixingDevice;

}
