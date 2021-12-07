/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

import java.util.Scanner;

/**
 *
 * @author HP ADMIN
 */
interface LoaiNhanVien
{
    void ChucVu();
    void Luong();
}
public class NVBanHang extends NhanVien implements LoaiNhanVien{
    Scanner sc=new Scanner(System.in);
    @Override
    public void ChucVu()
    {
        chucvu="NV ban hang";
    }
    @Override
    public void Luong()
    {
        luong="10.000.000vnd";
    }
}
