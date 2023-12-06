package com.example.demo;

import com.example.demo.models.Employee;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
public class DemoApplication {

	private static Employee[] arrayOfEmps = {
			new Employee(1, "Jeff Bezos", 1000000.0),
			new Employee(2, "Bill Gates", 2000000.0),
			new Employee(3, "Mark Zuckerberg", 3000000.0)
	};

//test
	@GetMapping("/")
	public String home() {
		return "Spring is here!";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Stream.of(arrayOfEmps);
		List<Employee> employeeList = Arrays.asList(arrayOfEmps);
		employeeList.stream();


        Stream.Builder<Employee> employeeBuilder = Stream.builder();

        employeeBuilder.accept(arrayOfEmps[0]);
        employeeBuilder.accept(arrayOfEmps[1]);
        employeeBuilder.accept(arrayOfEmps[2]);

        Stream<Employee> employeeStream = employeeBuilder.build();
		/**
		 * Stream.map()
		 *
		 * devuelve una secuencia que consta de los resultados de aplicar
		 * la función dada a los elementos de esta secuencia.
		 */
        /*List<String> employeeList1= employeeStream.map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(employeeList1);

        List<Double> employeeList2= employeeStream.map(e -> e.getMoney()).collect(Collectors.toList());
        System.out.println(employeeList2);

        List<Integer> employeeList3= employeeStream.map(e -> e.getId()).collect(Collectors.toList());
        System.out.println(employeeList3);*/

		/**
		 * forEach()
		 *
		 * Operacion simple y comun; recorre los elementos de la secuencia
		 * y llama a la funcion proporcionada en cada elemento
		 *
		 */



		/*List<Employee> employeeList4 =  Arrays.stream(arrayOfEmps).collect(Collectors.toList());
		employeeList4.forEach(e -> e.sumarMoney(3000000.0));
		/**
		 * Por lo tanto, solo podemos realizar una única operación que consume un Stream ;
		 * de lo contrario, obtendremos una excepción que indica que el Stream ya ha sido operado o cerrado.
		En pocas palabras, la solución consiste en crear un nuevo Stream cada vez que lo necesitemos
		employeeList4.forEach(e-> System.out.println(e.getMoney()));*/

		List<Employee> employeeList4 =  Arrays.stream(arrayOfEmps).collect(Collectors.toList());
		employeeList4.forEach(e -> {
			e.sumarMoney(3000000.0);
			System.out.println(e.getMoney());
		});

		Supplier<Stream<String>> streamSupplier
				= () -> Stream.of("A", "B", "C", "D");
		Optional<String> result1 = streamSupplier.get().findAny();
		System.out.println(((Optional<?>) result1).get());
		Optional<String> result2 = streamSupplier.get().findFirst();
		System.out.println(result2.get());
	}

}
