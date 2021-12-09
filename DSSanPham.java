/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HP ADMIN
 */
public class DSSanPham {
    Scanner sc=new Scanner(System.in);
    private int n;
    private SanPham []dssp;
    public DSSanPham()
    {
        n=0;
        dssp=null;
    }
    public void docDSSP()
    {
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSSP.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line =null;
            try 
            {
                
                n=demSP();
                dssp=new SanPham[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dssp[i]= new SanPham();
                    dssp[i].xuly(line);
                    i++;
                }
                
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int demSP()
    {
        int dem=0;
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSSP.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line=null;
            try 
            {
                
                while ((line = buffer.readLine())!=null)
                {
                    dem++;
                }
                n=dem;
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void capNhatDSSP()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSSP.txt");
            for(int i=0;i<n;i++)
            {
                String line = dssp[i].xylyLuu();
                try 
                {
                    byte []infor= line.getBytes("utf8");
                    try 
                    {
                        fos.write(infor);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(fos != null)
            {
                try 
                {
                    fos.close();
                } 
                catch (IOException ex) 
                {
                    Logger.getLogger(DSSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void themSP(SanPham sp)
    {
        dssp=Arrays.copyOf(dssp, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dssp[i]=sp;
            }
        }
        n++;
        capNhatDSSP();
    }
    public void xoaSP()
    {
        Matcher c;
        String a;
        do{
            System.out.println("Nhap ma san pham can xoa: ");
            a=sc.nextLine();
            String check="^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        }
        while(c.find()==false);
        for(int i=0;i<n;i++)
        {
            String key= dssp[i].getMaSP();
            if( key.contentEquals(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dssp[j]=dssp[j+1];
                }
                n--;
                dssp=Arrays.copyOf(dssp, n);
            }
        }
        capNhatDSSP();
    }
    public void suaSP()
    {
        Matcher c;
        String a;
        do{
            System.out.println("Nhap ma san pham can sua: ");
            a=sc.nextLine();
            String check="^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key=dssp[i].getMaSP();
            if(key.contentEquals(a)==true)
            {
                SanPham sp=new SanPham();
                System.out.println("Nhap thong tin san pham");
                sp.nhapSP();
                dssp[i]=sp;
            }
        }
        capNhatDSSP();
    }
    public void timkiemSp()
    {
        Matcher c;
        String a;
        do{
            System.out.println("Nhap ma san pham can tim: ");
            a=sc.nextLine();
            String check="^SP[0-9]{2}$";
            Pattern b = Pattern.compile(check);
            c = b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key = dssp[i].getMaSP();
            if(key.contentEquals(a)==true)
            {
                System.out.println("====================================================");
                System.out.printf("%-10s %-15s %-25s %-10s %-10s %-15s %-20s\n"
                    ,"STT","Ma san pham","Ten san pham","Mo ta","Bao hanh","Nha san xuat","So luong hien co");
                dssp[i].xuatSP();
                break;
            }
        }
    }
    public void xuatDSSP()
    {
        System.out.println("====================================================");
        System.out.printf("%-10s %-15s %-25s %-10s %-10s %-15s %-20s\n"
            ,"STT","Ma san pham","Ten san pham","Mo ta","Bao hanh","Nha san xuat","So luong hien co");
        for(int i=0;i<n;i++)
        {
            dssp[i].xuatSP();
        }
    }
}
