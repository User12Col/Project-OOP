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
public class DSPhieuBaoHanh {
    Scanner sc=new Scanner(System.in);
    private int n;
    private PhieuBaoHanh []dspbh;
    public DSPhieuBaoHanh()
    {
        n=0;
        dspbh=null;
    }
    public int demPBH()
    {
        int dem=0;
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSPBH.txt");
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
                Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dem;
    }
    public void docDSPBH()
    {
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSPBH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line =null;
            try 
            {
                n=demPBH();
                dspbh=new PhieuBaoHanh[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dspbh[i]= new PhieuBaoHanh();
                    dspbh[i].xuly(line);
                    i++;
                }
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void capNhatDSPBH()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSPBH.txt");
            for(int i=0;i<n;i++)
            {
                String line = dspbh[i].xylyLuu();
                try 
                {
                    byte []infor= line.getBytes("utf8");
                    try 
                    {
                        fos.write(infor);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(DSPhieuBaoHanh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void themPBH(PhieuBaoHanh pbh)
    {
        dspbh=Arrays.copyOf(dspbh, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dspbh[i]=pbh;
            }
        }
        n++;
        capNhatDSPBH();
        PhieuBaoHanh.setDem(1);
    }
    public void xoaPHB()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma phieu bao hanh can xoa: ");
            a=sc.nextLine();
            String check="^PBH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key= dspbh[i].getMaPBH();
            if( key.contentEquals(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dspbh[j]=dspbh[j+1];
                }
                n--;
                dspbh=Arrays.copyOf(dspbh, n);
            }
        }
        capNhatDSPBH();
        PhieuBaoHanh.setDem(1);
    }
    public void suaPBH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma phieu bao hanh can sua: ");
            a=sc.nextLine();
            String check="^PBH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key=dspbh[i].getMaPBH();
            if(key.contentEquals(a)==true)
            {
                PhieuBaoHanh pbh=new PhieuBaoHanh();
                System.out.println("Nhap thong tin phieu bao hanh");
                pbh.nhapPBH();
                dspbh[i]=pbh;
            }
        }
        capNhatDSPBH();
        PhieuBaoHanh.setDem(1);
    }
    public void timkiemPBH()
    {
        Matcher c;
        String a;
        do
        {
            System.out.println("Nhap ma phieu bao hanh can tim: ");
            a=sc.nextLine();
            String check="^PBH[0-9]{2}$";
            Pattern b= Pattern.compile(check);
            c= b.matcher(a);
        }
        while(c.find()==false);
        
        for(int i=0;i<n;i++)
        {
            String key = dspbh[i].getMaPBH();
            if(key.contentEquals(a)==true)
            {
                System.out.println("====================================================");
                System.out.printf("%-10s %-20s %-15s %-30s %-20s %-20s\n"
                    ,"STT","Ma phieu bao hanh","Ma khach hang","Dia chi bao hanh","Thoi han bao hanh","Tinh trang bao hanh");
                dspbh[i].xuatPBH();
                break;
            }
        }
        PhieuBaoHanh.setDem(1);
    }
    public void xuatDSPBH()
    {
        System.out.println("====================================================");
        System.out.printf("%-10s %-20s %-15s %-30s %-20s %-20s\n"
        ,"STT","Ma phieu bao hanh","Ma khach hang","Dia chi bao hanh","Thoi han bao hanh","Tinh trang bao hanh");
        for(int i=0;i<n;i++)
        {
            dspbh[i].xuatPBH();
        }
        PhieuBaoHanh.setDem(1);
    }
}
