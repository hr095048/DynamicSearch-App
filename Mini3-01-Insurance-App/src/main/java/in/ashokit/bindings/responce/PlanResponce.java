package in.ashokit.bindings.responce;

import lombok.Data;

@Data
public class PlanResponce {
	
	private Integer planId;
	private String planName;
	private String holderName;
	private Integer holderSsn;
	private String planStatus;

}
