package com.test.valid;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 
 * @author xzy
 * 注解处理类
 *
 */
public class RequestValidInterceptor {

	public void before(JoinPoint joinPoint){
		//准备切入点的参数和方法
		Object[] args =  joinPoint.getArgs(); //获取拦截方法的参数
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature)signature;
		Method method = methodSignature.getMethod();
		Annotation[][] pAnnotations = method.getParameterAnnotations();
		
		//获取参数的注解和方法值
		for(int i=0; i<args.length; i++){
			for(Annotation pAnnotation:pAnnotations[i]){
				String pAnn = pAnnotation.toString();
				String substring = pAnn.substring(1,15);
				
				//判断是否属于我们的验证注解
				if("com.test.valid".equals(substring)){
					Class<?> clazz = pAnnotation.getClass();
					
					Method pamaType = null;
					PamaType typeInvoke =null;
					//判断需要验证的类型（是否是基本类型）
					try {
						pamaType = clazz.getDeclaredMethod("pamaType", null);
					} catch (NoSuchMethodException e2) {
						e2.printStackTrace();
					} catch (SecurityException e2) {
						e2.printStackTrace();
					}
					try {
						typeInvoke = (PamaType)pamaType.invoke(pAnnotation, null);
					} catch (IllegalAccessException e2) {
						e2.printStackTrace();
					} catch (IllegalArgumentException e2) {
						e2.printStackTrace();
					} catch (InvocationTargetException e2) {
						e2.printStackTrace();
					}
					
					//判断是否是基本类型的方法
					if("base".equals(typeInvoke.getType())){
						//定义方法通过反射验证我们的参数
						this.newInt(clazz, pAnnotation, args[i],"pamaMethod");
					
					//复杂类型的方法
					}else if("complexty".equals(typeInvoke.getType())){
						if(args[i] != null){
						     Class<?> argClazz = args[i].getClass();
						     
						     //利用反射获取属性值
						     Field[] fields =  argClazz.getDeclaredFields();
						     for(int j = 0; j < fields.length; j++){
						        Field field = fields[j];
						        field.setAccessible(true);
						        Object object = null;
								try {
									object = field.get(args[i]);
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								}
								
								Annotation[] annotations = field.getAnnotations();
								for(Annotation annotation:annotations){
									Class<?> anClazz = annotation.getClass();
									//传递class类注解还有数据，完成验证
									this.newInt(anClazz, annotation, object,"pamaField");
								}							
						      }
						}
					}
				}
			}	
		}
	}
	
	/**
	 * 根据注解实现方法
	 */
	private void newInt(Class<?> clazz,Annotation pAnnotation,Object object,String pama){
		Method pamaMethod=null;
		Pama pamaInvoke =null;
		String classInvoke = null;
		String methodInvoke = null;
		try {
			pamaMethod = clazz.getDeclaredMethod(pama, null);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
		try {
			pamaInvoke = (Pama)pamaMethod.invoke(pAnnotation, null);
			classInvoke = pamaInvoke.getClassValue();
			methodInvoke = pamaInvoke.getMethodValue();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//验证方法的反射
		Class<?> clazzPama = null;
		try {
			clazzPama = Class.forName(classInvoke);
			Object newInstance = clazzPama.newInstance();
			Method methodPama=clazzPama.getDeclaredMethod(methodInvoke, Object.class);
			methodPama.invoke(newInstance, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}