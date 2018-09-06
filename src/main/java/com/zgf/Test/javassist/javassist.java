package com.zgf.Test.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class javassist {
    public static void main(String[] args) throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("com.zgf.Test.javassist.Student");
        CtMethod execute = ctClass.getDeclaredMethod("execute");
        System.out.println(execute.getLongName());
        System.out.println(execute.getName());
        System.out.println(execute.getReturnType());
        execute.insertBefore("System.out.println(\"before $1\");");
        execute.insertAfter("System.out.println(\"after $1\");");

        ctClass.toClass();

        Student student = new Student();
        student.execute(1);
    }
}

class Student {
    public void execute(int i) {
        System.out.println("test" + i);
    }
}