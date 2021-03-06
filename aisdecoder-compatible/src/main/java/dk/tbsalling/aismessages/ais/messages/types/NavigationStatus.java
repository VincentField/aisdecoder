

package dk.tbsalling.aismessages.ais.messages.types;

public enum NavigationStatus {
	UnderwayUsingEngine (0),
	AtAnchor(1),
	NotUnderCommand(2),
	RestrictedManoeuverability(3),
	ConstrainedByHerDraught(4),
	Moored(5),
	Aground(6),
	EngagedInFising(7),
	UnderwaySailing(8),
	ReservedForFutureUse9(9),
	ReservedForFutureUse10(10),
	PowerDrivenVesselTowingAstern(11),
	PowerDrivenVesselPushingAheadOrTowingAlongside(12),
	ReservedForFutureUse13(13),
	SartMobOrEpirb(14),
	Undefined(15);

	NavigationStatus(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getValue() {
	    return toString();
	}

	private final Integer code;

	public static NavigationStatus fromInteger(Integer integer) {
		if (integer != null) {
			for (NavigationStatus b : NavigationStatus.values()) {
				if (integer.equals(b.code)) {
					return b;
				}
			}
		}
		return null;
	}
}
