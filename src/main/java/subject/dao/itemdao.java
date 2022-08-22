package subject.dao;

import java.util.*;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import subject.vo.itemvo;




public class itemdao implements Itemdaointerface{
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
			private static DataSource ds = null;
			static {
				try{
					Context ctx = new InitialContext();
					ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQL");
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}
			
				
				private static final String GET_ALL_STMT = 
					"SELECT item_serial_number, item_name, item_description,item_price,item_stock, item_category_number, photo from letitgo.item \r\n"
					+ "where seller_serial_number = 1002 order by item_serial_number;";
				private static final String GET_ONE_STMT = 
					"SELECT item_serial_number, item_name, item_description,item_price,item_stock, item_category_number, photo from letitgo.item where item_serial_number=?";
				private static final String INSERT = "INSERT INTO letitgo.item(item_name,item_description,item_price,item_stock,seller_serial_number,item_category_number,photo) VALUES(?,?,?,?,?,?,?)";
				private static final String UPDATE ="UPDATE item set item_name=?, item_description=?, item_price=?,item_stock=?, item_category_number=?, photo=?  where item_serial_number=?";
				private static final String DELETE ="DELETE FROM item where item_serial_number =?";
				
				
			
				
				
				@Override
				public itemvo findByPrimaryKey(Integer serialnumber) {

					itemvo itemvo = null;
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					try {

						con = ds.getConnection();
						pstmt = con.prepareStatement(GET_ONE_STMT);

						pstmt.setInt(1, serialnumber);

						rs = pstmt.executeQuery();

						while (rs.next()) {
							// itemvo 也稱為 Domain objects
							itemvo = new itemvo();
							itemvo.setSerialnumber(rs.getInt("item_serial_number"));
							itemvo.setName(rs.getString("item_name"));
							itemvo.setDescription(rs.getString("item_description"));
							itemvo.setPrice(rs.getInt("item_price"));
							itemvo.setStock(rs.getInt("item_stock"));
							itemvo.setCategoryno(rs.getString("item_category_number"));
							itemvo.setPhoto(rs.getBytes("photo"));
						}
						// Handle any driver errors
					} catch (SQLException se) {
						throw new RuntimeException("A database error occured. "
								+ se.getMessage());
						// Clean up JDBC resources
					} finally {
						if (rs != null) {
							try {
								rs.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (pstmt != null) {
							try {
								pstmt.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (con != null) {
							try {
								con.close();
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
						}
					}
					return itemvo;
				}

				
				
				
				@Override
				public List<itemvo> getAll() {
					List<itemvo> list = new ArrayList<itemvo>();
					itemvo itemvo = null;

					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;

					try {

						con = ds.getConnection();
						pstmt = con.prepareStatement(GET_ALL_STMT);
						rs = pstmt.executeQuery();

						while (rs.next()) {
							// itemvo 也稱為 Domain objects
							itemvo = new itemvo();
							itemvo.setSerialnumber(rs.getInt("item_serial_number"));
							itemvo.setName(rs.getString("item_name"));
							itemvo.setDescription(rs.getString("item_description"));
							itemvo.setPrice(rs.getInt("item_price"));
							itemvo.setStock(rs.getInt("item_stock"));
							itemvo.setCategoryno(rs.getString("item_category_number"));
							itemvo.setPhoto(rs.getBytes("photo"));							
							list.add(itemvo); // Store the row in the list							
							
						}
						// Handle any driver errors
					} catch (SQLException se) {
						System.out.println("111");
					} finally {
						if (rs != null) {
							try {
								rs.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (pstmt != null) {
							try {
								pstmt.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (con != null) {
							try {
								con.close();
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
						}
					}
					return list;
					
				}
				
				
				
				@Override
				public void insert(itemvo itemvo) {

					Connection con = null;
					PreparedStatement pstmt = null;
					System.out.println("111111111111");
					try {

						con = ds.getConnection();
						pstmt = con.prepareStatement(INSERT);

						pstmt.setString(1,itemvo.getName());
						pstmt.setString(2, itemvo.getDescription());
						pstmt.setInt(3,itemvo.getPrice());
						pstmt.setInt(4, itemvo.getStock());
						pstmt.setInt(5, itemvo.getSellerserialnumber());
						pstmt.setString(6,itemvo.getCategoryno());
						pstmt.setBytes(7, itemvo.getPhoto());

						pstmt.executeUpdate();						
					} catch (SQLException se) {
						System.out.println("資料沒進去");
					} finally {
						if (pstmt != null) {
							try {
								pstmt.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (con != null) {
							try {
								con.close();
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
						}
					}
				}

				
				@Override
				public void update(itemvo itemvo) {

					Connection con = null;
					PreparedStatement pstmt = null;

					try {

						con = ds.getConnection();
						pstmt = con.prepareStatement(UPDATE);
						
						
						pstmt.setString(1,itemvo.getName());
						pstmt.setString(2, itemvo.getDescription());
						pstmt.setInt(3,itemvo.getPrice());
						pstmt.setInt(4, itemvo.getStock());
						pstmt.setInt(5, itemvo.getSellerserialnumber());
						pstmt.setString(5,itemvo.getCategoryno());
						pstmt.setBytes(6, itemvo.getPhoto());
						pstmt.setInt(7,itemvo.getSerialnumber());
						
						
						pstmt.executeUpdate();
					} catch (SQLException se) {
						System.out.println("資料沒進去");
					} finally {
						if (pstmt != null) {
							try {
								pstmt.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (con != null) {
							try {
								con.close();
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
						}
					}

				}

				
				@Override
				public void delete(Integer serialnumber) {

					Connection con = null;
					PreparedStatement pstmt = null;

					try {

						con = ds.getConnection();
						pstmt = con.prepareStatement(DELETE);

						pstmt.setInt(1, serialnumber);

						pstmt.executeUpdate();
					} catch (SQLException se) {
						System.out.println("資料沒刪掉");
					} finally {
						if (pstmt != null) {
							try {
								pstmt.close();
							} catch (SQLException se) {
								se.printStackTrace(System.err);
							}
						}
						if (con != null) {
							try {
								con.close();
							} catch (Exception e) {
								e.printStackTrace(System.err);
							}
						}
					}
					
					
				}
				
			
	
}
