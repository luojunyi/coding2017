package com.coderising.jvm.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.coderising.jvm.clz.ClassFile;

public class ClassFileLoader
{
    private List<String> clzPaths = new ArrayList<String>();
    
    public byte[] readBinaryCode(String className)
    {
        className = className.replace('.', File.separatorChar) + ".class";
        for (String path : clzPaths)
        {
            String clzFileName = path + File.separator + className;
            byte[] codes = loadClassFile(clzFileName);
            if (codes != null)
                return codes;
        }
        return null;
    }
    
    private static byte[] loadClassFile(String clzFileName)
    {
        File file = new File(clzFileName);
        byte[] bs = new byte[(int)file.length()];
        InputStream is = null;
        int i = 0;
        try
        {
            is = new FileInputStream(file);
            int temp = 0;
            while ((temp = is.read()) != -1)
            {
                bs[i] = (byte)temp;
                i++;
            }
            return bs;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public void addClassPath(String path)
    {
        if (this.clzPaths.contains(path))
            return;
        this.clzPaths.add(path);
    }
    
    public String getClassPath()
    {
        return StringUtils.join(this.clzPaths, ";");
    }
    
    public ClassFile loadClass(String className)
    {
       return null;
        
    }
    
    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(255));
    }
}