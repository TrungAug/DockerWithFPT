package ntt.aug.docker.entity;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Nationalized //hỗ trợ tiếng việt, Nvarchar
	@Column(length = Integer.MAX_VALUE)
	private String content;
	private int important;//Càng nhỏ, càng quan trọng
	
	
	
}
