<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>forget</title>
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
          style="background-color: white; margin-top: 30vh"
        >
          <form
            action="<%=request.getContextPath()%>/forget"
            method="post"
            id="emailInfo"
          >
            <h4 class="text-center mb-3">重新設定密碼</h4>
            <div class="row justify-content-center">
              <label class="mr-2 mt-2" for="email">e-mail: </label>
              <input type="email" name="email" id="email" />
              <!-- <div class="invalid-feedback">請輸入正確E-mail格式</div> -->
              <button
                class="btn btn-warning text-white"
                id="submitBtn"
                type="button"
              >
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
      const patternEmail =
        /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(?:\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$/;
      const email = document.getElementById('email');
      const emailInfo = document.getElementById('emailInfo');
      const submitBtn = document.getElementById('submitBtn');

      submitBtn.onclick = () => {
        let email = document.getElementById('email').value.trim();

        if (email === '' || !patternEmail.test(email)) {
          alert('請輸入正確信箱!!');
          return false;
        }

        //表單submit
        document.getElementById('emailInfo').submit();
      };

      // email.onchange = () => {
      //   let email = document.getElementById('email');
      //   email.classList.remove('is-invalid');

      //   if (!patternEmail.test(email.value)) {
      //     email.classList.add('is-invalid');
      //     return;
      //   }
      // };

      // document
      //   .getElementById('email')
      //   .addEventListener('change', validationEmail);

      // function validationEmail() {
      //   let email = document.getElementById('email');
      //   email.classList.remove('is-invalid');

      //   if (!patternEmail.test(email.value.trim())) {
      //     email.classList.add('is-invalid');
      //     return;
      //   }
      // }

      // function validation() {
      //   let email = document.getElementById('email').value.trim();

      //   if (email === '') {
      //     alert('請輸入信箱!!');
      //     return false;
      //   }
      //   //表單submit
      //   document.getElementById('emailInfo').submit();
      // }
    </script>
  </body>
</html>
