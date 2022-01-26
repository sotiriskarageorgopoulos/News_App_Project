@import gg.jte.Content
@param Content content

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/base.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <title>News App</title>
</head>

<body>
    <nav class="nav">
        <a class="nav-link" href="/index">News App</a>
        <a class="nav-link" href="/search">Search</a>
        <a class="nav-link" href="/history">Search History</a>
    </nav>
    ${content}
    <footer class="container-fluid footer-container">
        <div class="row">
            <div class="col-sm-4">
                <h2>Address</h2>
                <address>Lorem Ipsum 88, Honolulu</address>
                <h2>Contact Details</h2>
                <div class="footer-links">
                    <a class="footer-link" href="mailto:news@domain.com">news@domain.com</a>
                    <a class="footer-link" href="tel:2717717171717127">2717717171717127</a>
                </div>
            </div>
            <div class="col-sm-4">
                <h2 class="d-flex justify-content-center mt-5">News App</h2>
                <p class="d-flex justify-content-center mt-5">&copy; Copyright
                    <script>
                        document.write(new Date().getFullYear())
                    </script>
                </p>
            </div>
            <div class="col-sm-4">
                <div class="social-media">
                    <a href="https://www.facebook.com/"><i class="bi bi-facebook"></i></a>
                    <a href="https://www.instagram.com/"><i class="bi bi-instagram"></i></a>
                    <a href="https://twitter.com/"><i class="bi bi-twitter"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
    </script>
</body>
