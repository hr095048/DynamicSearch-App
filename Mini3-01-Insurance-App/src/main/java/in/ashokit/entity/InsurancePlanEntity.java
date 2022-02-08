package in.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Insurance_Plans")
public class InsurancePlanEntity {

	@Id
	@Column(name="Plan_Id")
	private Integer planId;
	@Column(name="Plan_Name")
	private String planName;
	@Column(name="Holder_Name")
	private String holderName;
	@Column(name="Holder_SSN")
	private Integer holderSsn;
	@Column(name="Plan_Status")
	private String planStatus;
}
