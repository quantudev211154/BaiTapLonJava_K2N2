use master
IF EXISTS (select * from sysdatabases where name='ThuNghiem')
		drop database ThuNghiem
GO
create database ThuNghiem

go
use ThuNghiem
go
CREATE TABLE BangDiaTN(
	"MaBD" int identity(1,1),
	"TenBD" nvarchar(100) NOT NULL,
	"TheLoai" nvarchar(50) NOT NULL,
	"TinhTrang" tinyint NOT NULL,
	"HangSX" nvarchar(50) NOT NULL,
	"GhiChu" nvarchar(150) NULL,
	"SoLuongGoc" int NOT NULL,
	"SoLuongTon" int NOT NULL,
	"DonGia" money NOT NULL,
	"GiaThue" money NOT NULL,
	CONSTRAINT "PK_MaBD_TN" PRIMARY KEY ("MaBD")
)
GO

CREATE TABLE NhanVienTN(
	"MaNV" int identity(1,1),
	"TenNV" nvarchar(50) NOT NULL,
	"GioiTinh" tinyint NOT NULL,
	"SoDT" nvarchar(10) NOT NULL,
	"MoTa" nvarchar(150) NULL,
	CONSTRAINT "PK_MaNV_TN" PRIMARY KEY ("MaNV")
)
GO

CREATE TABLE TaiKhoanTN(
	"MaNV" int NOT NULL,
	"MatKhau" varchar(15) NOT NULL,
	"LoaiTK" tinyint NOT NULL,
	CONSTRAINT "FK_MaNV_0_TN" FOREIGN KEY ("MaNV")
		REFERENCES NhanVienTN("MaNV") ON DELETE CASCADE ON UPDATE CASCADE
)
GO


CREATE TABLE TheThanhVienTN(
	"MaThe" int identity(1,1),
	"MaNV" int NOT NULL,
	"NgayLap" datetime NOT NULL,
	"NgayHetHan" datetime NOT NULL,
	CONSTRAINT "PK_MaThe_TN" PRIMARY KEY ("MaThe"),
	CONSTRAINT "FK_MaNV_1_TN" FOREIGN KEY ("MaNV")
		REFERENCES NhanVienTN("MaNV") --ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO

CREATE TABLE KhachHangTN(
	"MaKH" int identity(1,1),
	"MaThe" int NOT NULL,
	"HoTen" nvarchar(50) NOT NULL,
	"GioiTinh" tinyint NOT NULL,
	"SoDT" varchar(10) NOT NULL,
	"DiaChi" nvarchar(200) NOT NULL,
	"SoCMND" varchar(9) NOT NULL,
	CONSTRAINT "PK_MaKH_TN" PRIMARY KEY ("MaKH"),
	CONSTRAINT "FK_MaThe_0_TN" FOREIGN KEY ("MaThe")
		REFERENCES TheThanhVienTN("MaThe") --ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO

CREATE TABLE PhieuThueTN(
	"MaPhieuThue" int identity(1,1),
	"MaThe" int NOT NULL,
	"MaNV" int NOT NULL,
	"NgayLap" datetime NOT NULL,
	CONSTRAINT "PK_MaPhieuThue_TN" PRIMARY KEY ("MaPhieuThue"),
	CONSTRAINT "FK_MaThe_1_TN" FOREIGN KEY ("MaThe")
		REFERENCES TheThanhVienTN("MaThe"), --ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT "FK_MaNV_2_TN" FOREIGN KEY ("MaNV")
		REFERENCES NhanVienTN("MaNV") --ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO

CREATE TABLE ChiTietPhieuThueTN(
	"MaPhieuThue" int NOT NULL,
	"MaBD" int NOT NULL,
	"SoLuong" int NOT NULL,
	"NgayHetHan" datetime NOT NULL,
	"ThanhTien" money NOT NULL,
	CONSTRAINT "FK_MaPhieuThue_TN" FOREIGN KEY ("MaPhieuThue")
		REFERENCES PhieuThueTN("MaPhieuThue"), --ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT "FK_MaBD_TN" FOREIGN KEY ("MaBD")
		REFERENCES BangDiaTN("MaBD") --ON DELETE NO ACTION ON UPDATE CASCADE
)
GO

CREATE TABLE PhieuTraTN(
	"MaPhieuTra" int identity(1,1),
	"MaThe" int NOT NULL,
	"ManV" int NOT NULL,
	"NgayLap" datetime NOT NULL,
	CONSTRAINT "PK_MaPhieuTra_TN" PRIMARY KEY ("MaPhieuTra"),
	CONSTRAINT "FK_MaThe_2_TN" FOREIGN KEY ("MaThe")
		REFERENCES TheThanhVienTN("MaThe"),-- ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT "FK_MaNV_3_TN" FOREIGN KEY ("MaNV")
		REFERENCES NhanVienTN("MaNV") --ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO

CREATE TABLE ChiTietPhieuTraTN(
	"MaPhieuTra" int NOT NULL,
	"MaBD" int NOT NULL,
	"SoLuong" int NOT NULL,
	"TinhTrangDia" tinyint NOT NULL,
	"SoTienPhat" money NOT NULL,
	CONSTRAINT "FK_MaPhieuTra_TN" FOREIGN KEY ("MaPhieuTra")
		REFERENCES PhieuTraTN("MaPhieuTra"), --ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT "FK_MaBD2_TN" FOREIGN KEY ("MaBD")
		REFERENCES BangDiaTN("MaBD") --ON DELETE NO ACTION ON UPDATE NO ACTION
)
GO

CREATE TABLE DoanhThuTN(
	"MaTK" int identity(1,1),
	"MaPhieu" int NOT NULL,
	"LoaiPhieu" tinyint NOT NULL,
	"SoTien" money NOT NULL,
	"ThoiGian" datetime NOT NULL,
	CONSTRAINT "PK_MaTK_TN" PRIMARY KEY ("MaTK"),
	CONSTRAINT "FK_MaPhieu1_TN" FOREIGN KEY ("MaPhieu")
		 REFERENCES PhieuThueTN("MaPhieuThue") --ON DELETE CASCADE ON UPDATE CASCADE,
)
GO

insert NhanVienTN(TenNV, GioiTinh, SoDT, MoTa) values ('asasdd', 2, '123132', NULL)
select * from NhanVienTN