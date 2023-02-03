package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Producto;
import conex.BDConex;

public class ProductoDao {
	
	private static BDConex conex = new BDConex();
	
	public static ArrayList<Producto> getProductos() {
		
		String sql = "select * from producto";
		
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		
		try (Connection con = conex.getConnection()) {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				String imagen = rs.getString("imagen");
				double precio = rs.getDouble("precio");
				
				Producto producto = new Producto(id, nombre, descripcion, imagen, precio);
				
				listaProductos.add(producto);
			}
			
			rs.close();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}
}
