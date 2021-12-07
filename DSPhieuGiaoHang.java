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

/**
 *
 * @author HP ADMIN
 */
public class DSPhieuGiaoHang {
    Scanner sc=new Scanner(System.in);
    private int n;
    private PhieuGiaoHang []dspgh;
    public DSPhieuGiaoHang()
    {
        n=0;
        dspgh=null;
    }
    public int demPGH()
    {
        int dem=0;
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSPGH.txt");
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
    public void docDSPGH()
    {
        try 
        {
            FileInputStream file = new FileInputStream("D:/ChuongTrinh/InputDSPGH.txt");
            InputStreamReader reader = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader buffer = new BufferedReader(reader);
            String line =null;
            try 
            {
                n=demPGH();
                dspgh=new PhieuGiaoHang[n];
                int i=0;
                while((line = buffer.readLine())!=null)
                {
                    dspgh[i]= new PhieuGiaoHang();
                    dspgh[i].xuly(line);
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
    public void capNhatDSPGH()
    {
        FileOutputStream fos=null;
        try 
        {
            fos = new FileOutputStream("D:/ChuongTrinh/InputDSPGH.txt");
            for(int i=0;i<n;i++)
            {
                String line = dspgh[i].xylyLuu();
                try 
                {
                    byte []infor= line.getBytes("utf8");
                    try 
                    {
                        fos.write(infor);
                    } 
                    catch (IOException ex) 
                    {
                        Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } 
                catch (UnsupportedEncodingException ex) 
                {
                    Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Cap nhat du lieu thanh cong !!!");
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(DSNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void themPGH(PhieuGiaoHang pgh)
    {
        dspgh=Arrays.copyOf(dspgh, n+1);
        for(int i=0;i<n+1;i++)
        {
            if(i==n)
            {
                dspgh[i]=pgh;
            }
        }
        n++;
        capNhatDSPGH();
    }
    public void xoaPGH()
    {
        System.out.println("Nhap ma phieu giao hang can xoa: ");
        String a=sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String key= dspgh[i].getMaPGH();
            if( key.contains(a)== true)
            {
                for(int j=i;j<n-1;j++)
                {
                    dspgh[j]=dspgh[j+1];
                }
                n--;
                dspgh=Arrays.copyOf(dspgh, n);
            }
        }
        capNhatDSPGH();
    }
    public void suaPGH()
    {
        System.out.println("Nhap ma phieu giao hang can sua: ");
        String a= sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String key=dspgh[i].getMaPGH();
            if(key.contains(a)==true)
            {
                PhieuGiaoHang pgh=new PhieuGiaoHang();
                System.out.println("Nhap thong tin phieu giao hang");
                pgh.nhapPGH();
                dspgh[i]=pgh;
            }
        }
        capNhatDSPGH();
    }
    public void timkiemPGH()
    {
        System.out.println("Nhap ma phieu dat hang can tim: ");
        String a= sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String key = dspgh[i].getMaPGH();
            if(key.contains(a)==true)
            {
                dspgh[i].xuatPGH();
                break;
            }
        }
    }
    public void xuatDSPGH()
    {
        System.out.println("============================================================");
        System.out.printf("%-5s %-20s %-15s %-25s %-15s %-15s\n"
                ,"STT","Ma phieu giao hang","Ma hoa don","Tinh trang giao hang","Ngay bat dau","Ngay ket thuc");
        for(int i=0;i<n;i++)
        {
            dspgh[i].xuatPGH();
        }
    }
    
}
