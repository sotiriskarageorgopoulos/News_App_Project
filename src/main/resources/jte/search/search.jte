@import web.app.controllers.search.SearchPage
@import kar.sot.util.Article

@param SearchPage page
@param Article article

@layout.base(content = @`	
    <div class="container-fluid mt-5">
        <div class="row">
            <div class="col-sm-2">
                <form method="POST" action="/search_by_source">
                    <label for="source" class="label-form select-label mb-2">Search By Source</label>
                    <input name="source" id="source" class="select-input" />
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-sm btn-submit">Submit</button>
                    </div>
                </form>
            </div>
            <div class="col-sm-2">
                <form method="POST" action="/search_by_lang">
                    <label for="lang" class="label-form select-label mb-2">Search By Language</label>
                    <select name="lang" id="lang" class="select-input">
                        <option>Select...</option>
                        @for(var l: page.langs)
                          <option value="${l.getLanguage()}">${l.getLanguage()}</option>
                        @endfor
                    </select>
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-sm btn-submit">Submit</button>
                    </div>
                </form>
            </div>
            <div class="col-sm-4">
                <form method="POST" action="/search_by_term">
                    <label class="label-form input-label mb-2" for="term">Search by a term</label>
                    <input type="text" id="term" name="term" class="input-style" />
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-sm btn-submit">Submit</button>
                    </div>
                </form>
            </div>
            <div class="col-sm-2">
                <form method="POST" action="/search_by_category">
                    <label for="category" class="label-form select-label mb-2">Search By Category</label>
                    <select name="category"  id="category" class="select-input">
                        <option>Select...</option>
                        @for(var c: page.categories)
                        	<option value="${c}">${c}</option>
                        @endfor
                    </select>
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-sm btn-submit">Submit</button>
                    </div>
                </form>
            </div>
            <div class="col-sm-2">
                <form method="POST" action="/search_by_time_period">
                    <h4 class="search-title">Search By Time</h4>
                    <label class="label-form select-label mb-2">Term</label>
                	<input type="text" class="input-style" name="term" />
                    <label class="label-form input-label mb-2" for="from_date">From</label>
                    <input type="datetime-local" id="from_date" name="from_date" class="input-style" />
                    <label class="label-form input-label mb-2" for="to_date">To</label>
                    <input type="datetime-local" id="to_date" name="to_date" class="input-style" />
                    <div class="text-center mt-3">
                        <button type="submit" class="btn btn-sm btn-submit">Submit</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="row mt-5">
            @if(page.articles != null)
            	 @for(Article article : page.articles)
			        <div class="col-sm-4 mt-3">
			            <div class="card">
			            	@if(article.getUrlToImage() != null)
			                	<img src="${article.getUrlToImage()}" class="card-img-top" alt="${article.getTitle()}">
			                @endif
			                <div class="card-body">
			                    <h5 class="card-title">${article.getTitle()}</h5>
			                    <p class="card-text">${article.getDescription()}</p>
			                    <a href="${article.getUrl()}" class="btn btn-primary">See more...</a>
			                </div>
			                @if(article.getPublishedAt() != null)
				                <div class="card-footer text-muted">
				                  ${article.getPublishedAt().toString()}
				                </div>
				            @endif
			            </div>
			        </div>
			     @endfor
            @endif
        </div>
    </div>
`)