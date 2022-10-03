use [SmartHome]

go 

insert into vai_tro values 
('KH', N'Khách hàng'),
('NV', N'Nhân Viên'),
('GD', N'Giám Đốc')

go

insert into tai_khoan values 
('teonv', '123456789', '0123456789', N'Quảng Nam', 'teo@gmail.com', 1, 'user.jpg', N'Nguyễn Văn Tèo', 'NV', '123'),
('nott', '123456789', '0123456789', N'Đà Nẵng', 'no@gmail.com', 1, 'user.jpg', N'Trương Thị Nở', 'KH', '123'),
('pheocc', '123456789', '0123456789', N'Quảng Nam', 'pheo@gmail.com', 1, 'user.jpg', N'Cao Chí Phèo', 'GD', '123')

go

insert into danh_muc values 
(N'Thiết bị gia dụng'),
(N'Robot hút bụi'),
(N'Quạt + Sưởi thông minh'),
(N'Móc lọc không khí'),
(N'Thiết bị sức khỏe'),
(N'Nhà cửa đời sống'),
(N'Phụ kiện điện thoại'),
(N'Đèn thông minh'),
(N'Thiết bị nhà thông minh'),
(N'Phụ kiện ô tô + xe điện'),
(N'Thiết bị mạng')

go

insert into nha_cung_cap values
(null, null, N'abc'),
(null, null, N'bcd'),
(null, null, N'123'),
(null, null, N'xyz'),
(null, null, N'bnm')

go

insert into san_pham values 
(50000.0, 'bepdien.jpg', null, '02/10/2022', '02/10/2022', 1, N'Bếp điện', 1, 1, 1),
(60000.0, 'beptu.jpg', null, '02/10/2022', '02/10/2022', 1, N'Bếp từ', 1, 1, 1),
(70000.0, 'binhgiunhiet.jpg', null, '02/10/2022', '02/10/2022', 1, N'Bình giữ nhiệt', 1, 1, 1),
(80000.0, 'chao.png', null, '02/10/2022', '02/10/2022', 1, N'Chảo', 1, 1, 1),
(90000.0, 'mayxaysinhto.png', null, '02/10/2022', '02/10/2022', 1, N'Máy xay sinh tố', 1, 1, 1)

go

insert into danh_gia values
('02/10/2022', '02/10/2022', null, 1, 1, 'teonv'),
('02/10/2022', '02/10/2022', null, 1, 1, 'teonv'),
('02/10/2022', '02/10/2022', null, 1, 1, 'teonv'),
('02/10/2022', '02/10/2022', null, 1, 1, 'teonv'),
('02/10/2022', '02/10/2022', null, 1, 1, 'teonv')

go

insert into hinh_anh values
(null, 1),
(null, 1),
(null, 1),
(null, 1),
(null, 1)

go

insert into hoa_don values
('02/10/2022', '02/10/2022', '02/10/2022', 1, 'teonv'),
('02/10/2022', '02/10/2022', '02/10/2022', 1, 'teonv'),
('02/10/2022', '02/10/2022', '02/10/2022', 1, 'teonv'),
('02/10/2022', '02/10/2022', '02/10/2022', 1, 'teonv'),
('02/10/2022', '02/10/2022', '02/10/2022', 1, 'teonv')

go

insert into hoa_don_chi_tiet values
(10, 15000, 50, 1, 1, 1),
(10, 15000, 50, 1, 1, 1),
(10, 15000, 50, 1, 1, 1),
(10, 15000, 50, 1, 1, 1),
(10, 15000, 50, 1, 1, 1)

go

insert into khuyen_mai values
(50, '02/10/2022', '02/10/2022', 1),
(50, '02/10/2022', '02/10/2022', 1),
(50, '02/10/2022', '02/10/2022', 1),
(50, '02/10/2022', '02/10/2022', 1),
(50, '02/10/2022', '02/10/2022', 1)

go

insert into phan_quyen values
('teonv', 'NV'),
('nott', 'KH'),
('pheocc', 'GD')

go