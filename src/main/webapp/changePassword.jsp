<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>checkVerification</title>
    <!-- <link
		  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
		  rel="stylesheet"
		  integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
		  crossorigin="anonymous"
		/> -->
    <!-- Google Font -->
    <link
      href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
      rel="stylesheet"
    />

    <!-- Css Styles -->
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
      rel="stylesheet"
    />
    <!--自然改-->
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" />
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css" />
    <link rel="stylesheet" href="css/nice-select.css" type="text/css" />
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css" />
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css" />
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css" />
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
    <style>
      /* .header {
			height: 100px;
			border: 2px solid red;
		  } */
      .content {
        /* height: 600px; */
        height: 100%;
        background-image: url(./img/login-1.jpg);
        background-size: cover;
      }
      .let-it-go {
        margin: 20% 0;
      }
      h1,
      h3 {
        text-align: center;
        color: antiquewhite;
      }
      .login {
        background-color: white;
        height: 440px;
      }
    </style>
  </head>
  <body>
    <!-- Header Section Begin -->
    <jsp:include page="/header.jsp"></jsp:include>
    <!-- Header Section End -->
    <section class="container-fluid content">
      <div class="row justify-content-center">
        <div
          class="col-4 p-5 rounded"
          style="background-color: white; margin-top: 20vh"
        >
          <form action="<%=request.getContextPath()%>/changePassword" method="post" id="passwordInfo">
            <h4 class="text-center">重新設定密碼</h4>
            <div>
              <div>
                <label class="mr-2 mt-2" for="newPassword">新密碼: </label>
                <input class="w-100" type="text" name="newPassword" id="newPassword" />
                <div class="invalid-feedback">
                  請輸入正確密碼格式(6個字以上，含至少一個英文字母大小寫)
                </div>
              </div>              

              <div>
                <label class="mr-2 mt-2" for="checkPassword">確認密碼: </label>
                <input class="w-100" type="text"  name="checkPassword" id="checkPassword" />
                <div class="invalid-feedback">
                  請輸入正確密碼格式(6個字以上，含至少一個英文字母大小寫)
                </div>
              </div>
              
              <button class="btn btn-warning text-white mt-3 w-100" id="submitBtn" type="submit">
                Submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>

    <!-- <h1>Footer</h1> -->
    <!-- Footer Section Begin -->
    <jsp:include page="/footer.jsp"></jsp:include>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/axios.min.js"></script>
    <script>
      const newPassword = document.getElementById('newPassword');
      const checkPassword = document.getElementById('checkPassword');
      const submitBtn = document.getElementById('submitBtn');
      const passwordInfo = document.getElementById('passwordInfo');
      const pattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/;

      newPassword.onchange = () => {
        newPassword.classList.remove('is-invalid');

        if (!pattern.test(newPassword.value.trim())) {
          newPassword.classList.add('is-invalid');
        }
      };

      checkPassword.onchange = () => {
        checkPassword.classList.remove('is-invalid');

        if (!pattern.test(checkPassword.value.trim())) {
          checkPassword.classList.add('is-invalid');
        }
      };

      submitBtn.onclick = () => {
        let newPassword = document.getElementById('newPassword').value.trim();
        let checkPassword = document.getElementById('checkPassword').value.trim();

        if (newPassword === '' || checkPassword === '') {
          alert('請勿空白!!');
          return false;
        }

        if (!(newPassword === checkPassword)) {
          alert('請確認兩次密碼輸入相同!!');
          return false;
        }

        //表單submit
        document.getElementById('passwordInfo').submit();
      };
    </script>
  </body>
</html>