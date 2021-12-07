/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLy;

/**
 *
 * @author HP ADMIN
 */
public class NVQuanLy extends NhanVien implements LoaiNhanVien{
    @Override
    public void ChucVu()
    {
        chucvu="Nv quan ly";
    }
    @Override
    public void Luong()
    {
        luong="15.000.000vnd";
    }
}
