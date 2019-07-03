package com.example.start;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.model.Marca;
import com.example.model.Modelo;
import com.example.model.Persona;
import com.example.model.Usuario;
import com.example.model.Vehiculo;
import com.example.model.enums.PerfilUsuario;
import com.example.repository.MarcaRepository;
import com.example.repository.ModeloRepository;
import com.example.repository.PersonaRepository;
import com.example.repository.SolicitudRepository;
import com.example.repository.UsuarioRepository;
import com.example.repository.VehiculoRepository;

@SpringBootApplication
@EnableJpaRepositories("com.example.repository")
@ComponentScan(basePackages = { "com.example" })
@EntityScan(basePackages = "com.example.model")
public class StartApplication implements CommandLineRunner {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	SolicitudRepository solicitudRepository;

	@Autowired
	MarcaRepository marcaRepository;

	@Autowired
	ModeloRepository modeloRepository;

	@Autowired
	VehiculoRepository vehiculoRepository;

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("la aplicacion ha iniciado");
		System.out.println("grabando datos en la base de datos");
		Persona persona = new Persona();
		persona.setNombre("persona1");
		persona.setRut(11111111);
		persona.setDv('1');
		persona.setEmail("david@demo.cl");
		persona.setFechaNacimiento(LocalDate.now());
		personaRepository.save(persona);

		Persona persona2 = new Persona();
		persona2.setNombre("persona2");
		persona2.setRut(22222222);
		persona2.setDv('2');
		persona2.setEmail("david@demo.cl");
		persona2.setFechaNacimiento(LocalDate.now());
		personaRepository.save(persona2);

		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("solicitante");
		usuario.setContrasena("1234");
		usuario.setActivo(true);
		usuario.setPersona(persona);
		usuario.setPerfilUsuario(PerfilUsuario.SOLICITANTE);
		usuarioRepository.save(usuario);

		Usuario usuario2 = new Usuario();
		usuario2.setNombreUsuario("ejecutivo");
		usuario2.setContrasena("1234");
		usuario2.setActivo(true);
		usuario2.setPersona(persona2);
		usuario2.setPerfilUsuario(PerfilUsuario.EJECUTIVO);
		usuarioRepository.save(usuario2);

		Marca marca1 = new Marca();
		marca1.setNombre("Suzuki");
		marcaRepository.save(marca1);
		Marca marca2 = new Marca();
		marca2.setNombre("Ford");
		marcaRepository.save(marca2);

		Modelo modelo = new Modelo();
		modelo.setNombre("Grand Vitara GLX");
		modelo.setMarca(marca1);
		modeloRepository.save(modelo);

		Modelo modelo2 = new Modelo();
		modelo2.setNombre("Ranger");
		modelo2.setMarca(marca2);
		modeloRepository.save(modelo2);

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnio(2011);
		vehiculo.setChasis("RS3453453");
		vehiculo.setModelo(modelo);
		vehiculo.setPatente("DFRT67");
		vehiculoRepository.save(vehiculo);
		System.out.println("todo OK");
	}

}
