package com.fema.obstetricia.MenuItem.service;

import java.awt.MenuItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fema.obstetricia.MenuItem.model.ModeloMenuPrincipal;
import com.fema.obstetricia.MenuItem.repository.MenuPrincipalRepository;

@Service
public class MenuPrincipalService {

	@Autowired
	MenuPrincipalRepository menuItemRepository;
	
	public List<ModeloMenuPrincipal> listarMenus() {
		return this.menuItemRepository.findAll();
	}
}
