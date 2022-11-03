// chọn phần tử bắt buộc
const element = document.querySelector(".pagination ul");
let totalPages = 20;
let page = 10;

//gọi hàm với các tham số truyền và thêm phần tử bên trong là thẻ ul
element.innerHTML = createPagination(totalPages, page);
function createPagination(totalPages, page) {
	let liTag = '';
	let active;
	let beforePage = page - 1;
	let afterPage = page + 1;
	if (page > 1) { //hiển thị button tiếp theo nếu giá trị trang lớn hơn 1
		liTag += `<li class="btn prev" onclick="createPagination(totalPages, ${page - 1})"><span> « </span></li>`;
	}

	if (page > 2) { 
		liTag += `<li class="first numb" onclick="createPagination(totalPages, 1)"><span>1</span></li>`;
		if (page > 3) { //nếu giá trị trang lớn hơn 3 thì thêm dấu này (...) sau li đầu tiên hoặc trang
			liTag += `<li class="dots"><span>...</span></li>`;
		}
	}

	//có bao nhiêu trang hoặc thẻ li hiển thị trước li hiện tại
	if (page == totalPages) {
		beforePage = beforePage - 2;
	} else if (page == totalPages - 1) {
		beforePage = beforePage - 1;
	}
	//có bao nhiêu trang hoặc thẻ li hiển thị sau li hiện tại
	if (page == 1) {
		afterPage = afterPage + 2;
	} else if (page == 2) {
		afterPage = afterPage + 1;
	}

	for (var plength = beforePage; plength <= afterPage; plength++) {
		if (plength > totalPages) { //nếu plengtgh lớn hơn totalpage, độ dài tiếp tục tăng
			continue;
		}
		if (plength == 0) { //nếu plength =0 thì +1 vào giá trị plength 
			plength = plength + 1;
		}
		if (page == plength) { //nếu page bằng plength thì  gán active trong biến  
			active = "active";
		} else { //active để trống
			active = "";
		}
		liTag += `<li class="numb ${active}" onclick="createPagination(totalPages, ${plength})"><span>${plength}</span></li>`;
	}

	if (page < totalPages - 1) { //nếu giá trị page nhỏ hơn totalPage = -1 hiển thị trang cuối cùng
		if (page < totalPages - 2) { //nếu giá trị page nhỏ hơn totalPage = -2 thêm dấu (...) trước li hoặc trang cuối cùng
			liTag += `<li class="dots"><span>...</span></li>`;
		}
		liTag += `<li class="last numb" onclick="createPagination(totalPages, ${totalPages})"><span>${totalPages}</span></li>`;
	}

	if (page < totalPages) { //hiển thị button tiếp theo nếu page nhỏ hơn totalPages(20)
		liTag += `<li class="btn next" onclick="createPagination(totalPages, ${page + 1})"><span> » </span></li>`;
	}
	element.innerHTML = liTag; //thêm thẻ li vào bên trong thẻ ul
	return liTag;
}

 
    
        
        
      