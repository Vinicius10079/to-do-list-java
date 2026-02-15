package br.com.vinicius.to_do_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.vinicius.to_do_list.entity.To_Do;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void testCreatTo_DoSuccess(){
		var toDo = new To_Do("Tarefa A", "Descrição da tarefa A", false, 1);

		webTestClient
			.post()
			.uri("/to_dos")
			.bodyValue(toDo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].nome").isEqualTo(toDo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(toDo.getDescricao())
			.jsonPath("$[0].concluido").isEqualTo(toDo.isConcluido())
			.jsonPath("$[0].prioridade").isEqualTo(toDo.getPrioridade());
	}

	@Test
	void testCreatTo_DoFailure(){
		
		webTestClient
			.post()
			.uri("/to_dos")
			.bodyValue(new To_Do("", "", false, 0))
			.exchange()
			.expectStatus().isBadRequest();
	}
}
