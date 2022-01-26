@import web.app.controllers.index.IndexPage
@import kar.sot.util.Article

@param IndexPage page 

@layout.base(content = @`
<div class="container-fluid mt-5">
    <h2 class="top-headlines mt-5">Top Headlines</h2>
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-2">
            <form method="POST" class="form" action="/fetch_by_country">
                <label for="country" class="form-label select-label">Change country</label>
                <select id="country" name="country" class="select-input">
                    <option>Select...</option>
                    @for(var c : page.allCountries)
                      <option value="${c.getCountry()}">${c.getCountry()}</option>
                    @endfor
                </select>
                <div class="text-center">
                    <button type="submit" class="btn btn-sm mt-3 btn-submit">Submit</button>
                </div>
            </form>
        </div>
        <div class="col-sm-2">
            <form method="POST" class="form" action="/fetch_by_category">
                <label for="category" class="form-label select-label">Change category</label>
                <select id="category" name="category" class="select-input">
                    <option>Select...</option>
                    @for(var c: page.allCategories)
                      <option value="${c}">${c}</option>
                    @endfor
                </select>
                <div class="text-center">
                    <button type="submit" class="btn btn-sm mt-3 btn-submit">Submit</button>
                </div>
            </form>
        </div>
        <div class="col-sm-4">
        </div>
    </div>
    <div class="row">
	   @for(Article article : page.allTopHeadings)
        <div class="col-sm-4">
            <div class="card">
            	@if(article.getUrlToImage() != null)
                	<img src="${article.getUrlToImage()}" class="card-img-top" alt="${article.getTitle()}">
                @endif
                <div class="card-body">
                    <h5 class="card-title">${article.getTitle()}</h5>
                    <p class="card-text">${article.getDescription()}</p>
                    <a href="${article.getUrl()}" class="btn btn-primary">See more...</a>
                </div>
                <div class="card-footer text-muted">
                  ${article.getPublishedAt() != null? "Published:\t"+article.getPublishedAt().toString(): ""}
                </div>
            </div>
        </div>
        @endfor
    </div>
</div>
`)