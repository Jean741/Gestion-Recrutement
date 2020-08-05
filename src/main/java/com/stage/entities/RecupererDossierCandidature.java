package com.stage.entities;

import java.io.File;
import java.util.List;
/*
 * Cette classe permet de recuperer le contenu d'un dossier a partir du chemin 
 * en fesant apel a la fonction recupererFichiers
 * 
 */
public class RecupererDossierCandidature {
	private List<File> files;
	private String pathToFolder;


	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public String getPathToFolder() {
		return pathToFolder;
	}
	public void setPathToFolder(String pathToFolder) {
		this.pathToFolder = pathToFolder;
	}
	public void recupererFichiers(String pathToFolder) {
		// initialise les fichiers
	}
	public RecupererDossierCandidature() {
		super();
	}
	

}
