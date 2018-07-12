package com.jdbc.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import com.jdbc.custom.annotations.ColumnName;
import com.jdbc.custom.annotations.EntityProperties;

/**
 * @author jumathew
 *
 */
public class ReflectionUtils {


    enum Order
    {
        ASC("asc"), DESC("desc");
    	private String orderBy;
    	public String getOrderBy() {
			return orderBy;
		}
		public void setOrderBy(String orderBy) {
			this.orderBy = orderBy;
		}
		Order(String orderBy)
    	{
    	this.orderBy=orderBy;	
    	}
    }
 	
	public static EntityProperties getEntityAnnotation(Class clzz) {
		Annotation[]allAnnotations=clzz.getDeclaredAnnotations();
		for (Annotation annotation : allAnnotations) {
		if(annotation instanceof EntityProperties)
		{
			return (EntityProperties)annotation;
		}
		}
		throw new IllegalStateException("Entity Should be Annotated with @EntityProperties");
 	}
 
	public static String getPaginationQuery(Map<String, String>params,Class clzz)
	{
		Objects.requireNonNull(params.get("start"));
		Objects.requireNonNull(params.get("pageLength"));
 		
		StringJoiner queryString=new StringJoiner(" ");
		queryString.add("SELECT");
		queryString.add(getColumns(clzz));
		queryString.add("FROM");
		queryString.add(getEntityAnnotation(clzz).value());
		//orderby 
		String orderBy=params.getOrDefault("orderBy", null);
		
		if(orderBy!=null)
		{
			Objects.requireNonNull(params.get("orderDirection"));
			queryString.add("ORDER BY");
			queryString.add(getCoulumnNameFromRowPosition(orderBy,clzz));
			
		}
		queryString.add("LIMIT");
 		queryString.add(params.get("pageLength"));
		queryString.add("OFFSET");
 		queryString.add(params.get("start"));
		
		return queryString.toString();
	}
	
	private static String  getColumns(Class clzz)
	{
		List<ColumnName>coloumnsAnnotatedWithColumnName=new ArrayList<>();
		for (Field f: clzz.getDeclaredFields()) {
			ColumnName column = f.getAnnotation(ColumnName.class);
			   if (column != null)
				   coloumnsAnnotatedWithColumnName.add(column);
		}
		 String  concatenatedString =coloumnsAnnotatedWithColumnName.stream()
		.map(n->n.value())		
		.collect(Collectors.joining(","));
 		return concatenatedString;
	}
	private static String getCoulumnNameFromRowPosition(String rowPosition,Class clzz)
	{
		Optional<Field>field=Arrays.stream(clzz.getDeclaredFields()).filter(e->{
			return e.getAnnotation(ColumnName.class).rowPosition().equals(rowPosition);
		}).findFirst();
		
		if(field.isPresent()) {
			ColumnName column = field.get().getAnnotation(ColumnName.class);
			return column.value();
		}else {
			throw new IllegalStateException("orderDirection passsed is not matching with any fields in the entity class");
		}
		
	}
	

}
