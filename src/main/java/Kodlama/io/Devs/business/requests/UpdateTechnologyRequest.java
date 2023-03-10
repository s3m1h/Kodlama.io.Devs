package Kodlama.io.Devs.business.requests;

import Kodlama.io.Devs.business.responses.GetAllTechnologyResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyRequest {
	private int id;
	private String name;
}
