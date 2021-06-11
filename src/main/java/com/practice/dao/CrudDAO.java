package com.practice.dao;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.practice.bo.CrudBO;
import com.practice.constants.QueryConstants;
import com.practice.constants.TableConstants;
import com.practice.utils.DBUtils;
/*
 * author Saravana Ganesh
 * created on 11-June-2021
 */
public class CrudDAO {
	private static Connection connection = DBUtils.getDbConnection();
	
	public void insert(CrudBO crudBO) {
		try(PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.INSERT_STUDENT_TABLE)){
			System.out.println(QueryConstants.INSERT_STUDENT_TABLE);
			preparedStatement.setInt(1,crudBO.getId());
			preparedStatement.setString(2,crudBO.getName());
			preparedStatement.setString(3,crudBO.getDepartment());
			if(preparedStatement.executeUpdate()>0)
				System.out.println("Inserted Sucessfuly...");
			else
				System.out.println("Data not inserted....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void read() {
		try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery(QueryConstants.SELECT_STUDENT_TBL);
			while(resultSet.next()){
	            //Display values
	            System.out.println(TableConstants.STUDENT_ID+": " + resultSet.getInt(TableConstants.STUDENT_ID));
	            System.out.println(TableConstants.STUDENT_NAME+": " + resultSet.getString(TableConstants.STUDENT_NAME));
	            System.out.println(TableConstants.STUDENT_DEPARTMENT+": " + resultSet.getString(TableConstants.STUDENT_DEPARTMENT));
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	}
	public void update(CrudBO crudBO) {
		int result = 0;
		if(crudBO.getDepartment()!=null && crudBO.getName()!=null) {
			try(PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.UPDATE_STUDENT_TABLE_NAME_AND_DEPARTMENT)){
				System.out.println(QueryConstants.UPDATE_STUDENT_TABLE_NAME_AND_DEPARTMENT);
				preparedStatement.setString(1, crudBO.getName());
				preparedStatement.setString(2, crudBO.getDepartment());
				preparedStatement.setInt(3, crudBO.getId());
				result = preparedStatement.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(crudBO.getName()!=null) {
			try(PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.UPDATE_STUDENT_TABLE_NAME)){
				preparedStatement.setString(1, crudBO.getName());
				preparedStatement.setInt(2, crudBO.getId());
				result = preparedStatement.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(crudBO.getDepartment()!=null) {
			try(PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.UPDATE_STUDENT_TABLE_DEPARTMENT)){
				preparedStatement.setString(1, crudBO.getDepartment());
				preparedStatement.setInt(2, crudBO.getId());
				result = preparedStatement.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(result>0)
			System.out.println("Record Updated sucessfully...");
		else
			System.out.println("Record not updated...");
		
	}
	public void delete(CrudBO crudBO) {
		try(PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.DELETE_STUDENT)){
			preparedStatement.setInt(1, crudBO.getId());
			if(preparedStatement.executeUpdate()>0)
				System.out.println("Record deleted sucessfully...");
			else
				System.out.println("Record not deleted....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void WriteInFile() {

		try(	Statement statement = connection.createStatement();
				FileWriter fw=new FileWriter("StudentTableRecords.txt");
				PrintWriter out=new PrintWriter(fw)
			){
			ResultSet resultSet = statement.executeQuery(QueryConstants.SELECT_STUDENT_TBL);
			out.print(TableConstants.STUDENT_ID+"	"+TableConstants.STUDENT_NAME+"	"+TableConstants.STUDENT_DEPARTMENT+"\n");
			while(resultSet.next()){
	            //Display values				
				out.print(resultSet.getInt(TableConstants.STUDENT_ID)+"	");
				out.print(resultSet.getString(TableConstants.STUDENT_NAME)+"	");
				out.println(resultSet.getString(TableConstants.STUDENT_DEPARTMENT)+"	");	       
	         }
			out.flush();
	      } catch (Exception e) {
	         e.printStackTrace();
	      } 
	
	}

}
