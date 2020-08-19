package com.fema.obstetricia.MenuItem.resource;

import java.awt.MenuItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fema.obstetricia.MenuItem.model.ModeloMenuPrincipal;
import com.fema.obstetricia.MenuItem.service.MenuPrincipalService;

@RestController
@RequestMapping(value="menu-item")
public class MenuPrincipalResource {
	
	@Autowired
	private MenuPrincipalService menuItemService;
	
	@GetMapping
	public ResponseEntity<List<ModeloMenuPrincipal>> listarMenus() {
		List<ModeloMenuPrincipal> menuItem = this.menuItemService.listarMenus();
		return ResponseEntity.ok().body(menuItem);
	}
}
