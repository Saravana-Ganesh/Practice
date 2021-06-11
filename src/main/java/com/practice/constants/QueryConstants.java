package com.practice.constants;
/*
 * author Saravana Ganesh
 * created on 11-June-2021
 */
public final class QueryConstants {
	public static final String SELECT_STUDENT_TBL = ""
			+ "SELECT "+TableConstants.STUDENT_ID+","+TableConstants.STUDENT_NAME+","
			+TableConstants.STUDENT_DEPARTMENT+" FROM "+TableConstants.STUDENT;
	
	public static final String INSERT_STUDENT_TABLE = ""
			+ "INSERT INTO "+TableConstants.STUDENT+"("+TableConstants.STUDENT_ID+","+TableConstants.STUDENT_NAME+","+
			TableConstants.STUDENT_DEPARTMENT+") VALUES (?,?,?)";
	
	public static final String UPDATE_STUDENT_TABLE_NAME = ""
			+ "UPDATE "+TableConstants.STUDENT+" SET "+TableConstants.STUDENT_NAME+"=?"
					+ " WHERE "+TableConstants.STUDENT_ID+" =?";
	
	public static final String UPDATE_STUDENT_TABLE_DEPARTMENT = ""
			+ "UPDATE "+TableConstants.STUDENT+" SET "+TableConstants.STUDENT_DEPARTMENT+"=?"
					+ " WHERE "+TableConstants.STUDENT_ID+" =?";
	
	public static final String UPDATE_STUDENT_TABLE_NAME_AND_DEPARTMENT = ""
			+ "UPDATE "+TableConstants.STUDENT+" SET "+TableConstants.STUDENT_NAME+" = ? ,"
					+TableConstants.STUDENT_DEPARTMENT+"= ? WHERE "+TableConstants.STUDENT_ID+" =?";
	
	public static final String DELETE_STUDENT = "DELETE FROM "+TableConstants.STUDENT+" "
			+ " WHERE "+TableConstants.STUDENT_ID+" = ?";
			
}
