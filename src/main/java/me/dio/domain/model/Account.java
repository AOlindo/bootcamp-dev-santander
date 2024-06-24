package me.dio.domain.model;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String number;
	private String agency;
	
	@Column(scale = 13, precision = 2)
	private BigDecimal balance;
	//Defini o numero de casas decimais
	
	@Column(name = "additional_limit", scale = 13, precision = 2)
	private BigDecimal limit;
	
	
}
