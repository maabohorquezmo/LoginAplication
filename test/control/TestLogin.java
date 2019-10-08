/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Entidad.Usuario;
import static Frontera.FramePrincipal_1.sistema;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import Control.ValidarLogin;
import static org.junit.Assert.*;

/**
 *
 * @author Estudiante
 */
public class TestLogin {
    private static ValidarLogin validarlogin= new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA="Longitud nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA="Longitud contraseña incorrecta";
    private String DATOS_INCORRECTOS = "Datos incorrectos";
    private String USUARIO_AUTORIZADO = "Bienvenido";
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
         ArrayList<Usuario> usuarios= new ArrayList<Usuario>();
        
        
        Usuario a= new Usuario();
        Usuario b= new Usuario();
        Usuario c= new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        sistema.setUsuarios(usuarios);
        
        for(Usuario u: sistema.getUsuarios()){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("---------------");
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
      
    }

   
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testLongitudNombre() {
    
        Usuario u =new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarlogin.verificarLogin(u),LONG_NOMBRE_INCORRECTA);
        
        u.setNombre("ROBERTO");
        u.setPassword("123456");
        assertEquals(validarlogin.verificarLogin(u),LONG_NOMBRE_INCORRECTA);
        
        
       
        
        
        
    }
      @Test
    public void testLongitudContrasenia() {
    
        Usuario u =new Usuario();
        u.setNombre("pepe");
        u.setPassword("12");
        assertEquals(validarlogin.verificarLogin(u),LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("pepe");
        u.setPassword("123456");
        assertEquals(validarlogin.verificarLogin(u),LONG_PASSWORD_INCORRECTA);
        
    }        
       @Test
    public void testNombre() {
    
        Usuario u =new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarlogin.verificarLogin(u), DATOS_INCORRECTOS);
    }  
    @Test
    public void testContrasenia() {
    
        Usuario u =new Usuario();
        u.setNombre("maria");
        u.setPassword("1234");
        assertEquals(validarlogin.verificarLogin(u), DATOS_INCORRECTOS);
    }  
    @Test
    public void testDatos() {
    
        Usuario u =new Usuario();
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarlogin.verificarLogin(u), DATOS_INCORRECTOS);
        
       
    }        
  @Test
    public void testTodoCorrecto() {
        Usuario u =new Usuario();
        
        
        u.setNombre("juan");
        u.setPassword("1234");
        assertEquals(validarlogin.verificarLogin(u), USUARIO_AUTORIZADO);
               
        u.setNombre("pedro");
        u.setPassword("123");
        assertEquals(validarlogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("maria");
        u.setPassword("12345");
        assertEquals(validarlogin.verificarLogin(u), USUARIO_AUTORIZADO);
          

    }
    }
