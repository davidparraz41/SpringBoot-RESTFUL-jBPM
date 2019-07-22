package com.rentacar.start;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rentacar.model.Marca;
import com.rentacar.model.Modelo;
import com.rentacar.model.Persona;
import com.rentacar.model.Usuario;
import com.rentacar.model.Vehiculo;
import com.rentacar.model.enums.PerfilUsuario;
import com.rentacar.process.ProcessService;
import com.rentacar.repository.MarcaRepository;
import com.rentacar.repository.ModeloRepository;
import com.rentacar.repository.PersonaRepository;
import com.rentacar.repository.SolicitudRepository;
import com.rentacar.repository.UsuarioRepository;
import com.rentacar.repository.VehiculoRepository;

@SpringBootApplication
@EnableJpaRepositories("com.rentacar.repository")
@ComponentScan(basePackages = { "com.rentacar" })
@EntityScan(basePackages = "com.rentacar.model")
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

	@Autowired
	ProcessService processService;

	@Autowired
	Environment environment;

	public static void main(String[] args) throws IOException {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando la aplicacion...");
		System.out.println("Grabando datos iniciales en la base de datos...");
		Persona persona = new Persona();
		persona.setNombre("persona1");
		persona.setRut(11111111);
		persona.setDv('1');
		persona.setEmail("david@demo.cl");
		persona.setFechaNacimiento(LocalDate.now());
		personaRepository.save(persona);

		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("wbadmin");
		usuario.setContrasena("wbadmin");
		usuario.setActivo(true);
		usuario.setPersona(persona);
		usuario.setPerfilUsuario(PerfilUsuario.SOLICITANTE);
		usuarioRepository.save(usuario);

		persona = new Persona();
		persona.setNombre("persona2");
		persona.setRut(22222222);
		persona.setDv('2');
		persona.setEmail("david@demo.cl");
		persona.setFechaNacimiento(LocalDate.now());
		personaRepository.save(persona);

		usuario = new Usuario();
		usuario.setNombreUsuario("kieserver");
		usuario.setContrasena("kieserver1!");
		usuario.setActivo(true);
		usuario.setPersona(persona);
		usuario.setPerfilUsuario(PerfilUsuario.EJECUTIVO);
		usuarioRepository.save(usuario);

		Marca marca = new Marca();
		marca.setNombre("Suzuki");
		marcaRepository.save(marca);
		Modelo modelo = new Modelo();
		modelo.setNombre("Grand Vitara GLX");
		modelo.setMarca(marca);
		modeloRepository.save(modelo);

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setAnio(2011);
		vehiculo.setChasis("RS3453453");
		vehiculo.setModelo(modelo);
		vehiculo.setPatente("DFRT67");
		vehiculoRepository.save(vehiculo);

		marca = new Marca();
		marca.setNombre("Ford");
		marcaRepository.save(marca);

		modelo = new Modelo();
		modelo.setNombre("Ranger");
		modelo.setMarca(marca);
		modeloRepository.save(modelo);
		System.out.println("Los datos se han guardado con exito");
	}

}
