package com.ejbs.recetario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.security.SecurityConfig;
import com.ejbs.recetario.service.UsuarioService;

@Controller
public class LoginController {

    @Autowired
    UsuarioService repositorioUsuario;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static boolean reintento = false;

    @GetMapping({"/login"})
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("reintento", reintento);
        model.addAttribute("sesion", SecurityConfig.usuarioSesion);
        return "login";
    }

    @PostMapping("/login")
    public String revisarLogin(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
        Optional<Usuario> usuarioOpt = repositorioUsuario.obtenerUsuario(usuario.getEmail());
        if (!usuarioOpt.isPresent()) {
            reintento = true;
            return "redirect:/login";
        }
        Usuario usuarioComp = usuarioOpt.get();
        if (usuarioComp == null || !passwordEncoder.matches(usuario.getContrasenia(), usuarioComp.getContrasenia())) {
            reintento = true;
            return "redirect:/login";
        }
        reintento = false;
        SecurityConfig.usuarioSesion = usuarioComp;
        return "redirect:/recetas";
    }

}
