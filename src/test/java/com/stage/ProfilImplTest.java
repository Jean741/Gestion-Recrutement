/*
 * 
 */
package com.stage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stage.entities.Profil;
import com.stage.repository.ProfilRepository;
import com.stage.services.impl.ProfilImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfilImplTest.
 */
@ExtendWith(MockitoExtension.class)
class ProfilImplTest {
	private static Logger LOGGER = LoggerFactory.getLogger(ProfilImplTest.class);
	
	/** The profil repository. */
	@Mock
	private ProfilRepository profilRepository;

	/** The profil service. */
	@InjectMocks
	private ProfilImpl profilService;

	/**
	 * Sets the up.
	 */
	@BeforeEach
	public void setUp() {
	//	profilService = new 
		LOGGER.info("Start testing ProfilImplTest");
	}

	/**
	 * Test profil service.
	 */
	@Test
	void testProfilService_findAll_withEmptyProfil() {
		LOGGER.info("Start testing ProfilImplTest testProfilService_findAll_withEmptyProfil ");
		ArrayList<Profil> emptyValues = new ArrayList<Profil>();
		when(profilRepository.findAll()).thenReturn(emptyValues);
		assertEquals(emptyValues, profilService.findAll());
		LOGGER.info("End testing ProfilImplTest testProfilService_findAll_withEmptyProfil ");
	}
	@Test
	void testProfilService_findAll_withOneProfil() {
		LOGGER.info("Start testing ProfilImplTest testProfilService_findAll_withOneProfil ");
		List<Profil> listWithOneValue =List.of(Profil.builder().id(10L).build());
		when(profilRepository.findAll()).thenReturn(listWithOneValue);
		assertEquals(listWithOneValue, profilService.findAll());
		LOGGER.info("End testing ProfilImplTest testProfilService_findAll_withOneProfil ");
	}

}
