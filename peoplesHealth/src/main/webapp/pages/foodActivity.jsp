<div ng-app="mainApp">
	<div ng-controller="foodConsumptionController">
		<div class="pre-header">
			<div class="container">
				<div class="row">
					<!-- BEGIN TOP BAR LEFT PART -->
					<div class="col-md-6 col-sm-6 additional-shop-info">
						<ul class="list-unstyled list-inline">

						</ul>
					</div>
					<!-- END TOP BAR LEFT PART -->
					<!-- BEGIN TOP BAR MENU -->
					<div class="col-md-6 col-sm-6 additional-nav">
						<ul class="list-unstyled list-inline pull-right">
							<li><a href="#/loginPage">Log In</a></li>
							<li><a href="#/signUpPage">Sign Up</a></li>
						</ul>
					</div>
					<!-- END TOP BAR MENU -->
				</div>
			</div>
		</div>
		<!-- END TOP BAR -->
		<!-- BEGIN HEADER -->
		<div class="header">
			<div class="container">
				<a class="site-logo" href="index.jsp"><img
					src="${pageContext.request.contextPath}/resources/assets/corporate/img/logos/peoplesHealth.png"
					alt="people's health"></a> <a href="javascript:void(0);"
					class="mobi-toggler"><i class="fa fa-bars"></i></a>

				<!-- BEGIN NAVIGATION -->
				<div class="header-navigation pull-right font-transform-inherit">
					<ul>

						<li><a href="#/">Home</a></li>

						<li><a href="#/bmi">BMI</a></li>

						<li><a href="#/foodActivity">Food and Activity</a></li>

						<li><a href="#/analytics">Analytics</a></li>

					</ul>
				</div>
				<!-- END NAVIGATION -->
			</div>
		</div>
		<!-- Header END -->

		<div class="main">
			<div class="container">


				<!-- BEGIN SIDEBAR & CONTENT -->
				<div class="row margin-bottom-40">
					<!-- BEGIN CONTENT -->
					<div class="col-md-12 col-sm-12">
						<h1>What have you been up to?</h1>
						<div class="content-page">

							<div class="row">
								<!-- TABS -->
								<div class="col-md-10 tab-style-1">
									<ul class="nav nav-tabs">
										<li class="active"><a data-toggle="tab" href="#tab-1">Food
												Consumption</a></li>
										<li class=""><a data-toggle="tab" href="#tab-2">Activity</a></li>
									</ul>
									<div class="tab-content">
										<div id="tab-1" class="tab-pane row fade active in">
											<div class="col-md-12">
												<p>
													Today is <strong> {{todaysDate}} </strong> - select date
													below if you would like to input food for a different date.
												</p>
												<table>
													<tr>
														<td>Day <select class="form-control"
															name='foodConsumption_date_day'
															id="foodConsumption_date_day"
															ng-model="foodConsumption_date_day">
																<option value='1'>1</option>
																<option value='2'>2</option>
																<option value='3'>3</option>
																<option value='4'>4</option>
																<option value='5'>5</option>
																<option value='6'>6</option>
																<option value='7'>7</option>
																<option value='8'>8</option>
																<option value='9'>9</option>
																<option value='10'>10</option>
																<option value='11'>11</option>
																<option value='12'>12</option>
																<option value='13'>13</option>
																<option value='14'>14</option>
																<option value='15'>15</option>
																<option value='16'>16</option>
																<option value='17'>17</option>
																<option value='18'>18</option>
																<option value='19'>19</option>
																<option value='20'>20</option>
																<option value='21'>21</option>
																<option value='22'>22</option>
																<option value='23'>23</option>
																<option value='24'>24</option>
																<option value='25'>25</option>
																<option value='26'>26</option>
																<option value='27'>27</option>
																<option value='28'>28</option>
																<option value='29'>29</option>
																<option value='30'>30</option>
																<option value='31'>31</option>
														</select></td>
														<td>Month <select class="form-control" name='month'
															id="foodConsumption_date_month"
															ng-model="foodConsumption_date_month">
																<option value='1'>1</option>
																<option value='2'>2</option>
																<option value='3'>3</option>
																<option value='4'>4</option>
																<option value='5'>5</option>
																<option value='6'>6</option>
																<option value='7'>7</option>
																<option value='8'>8</option>
																<option value='9'>9</option>
																<option value='10'>10</option>
																<option value='11'>11</option>
																<option value='12'>12</option>
														</select></td>
														<td>Year <select class="form-control" name='day'
															id="foodConsumption_date_year"
															ng-model="foodConsumption_date_year">
																<option value='2014'>2016</option>
																<option value='2014'>2017</option>
														</select></td>
													</tr>
												</table>

												<form class="form-horizontal form-without-legend"
													role="form">
													<div class="form-group">
														<label for="foodName" class="col-lg-4 control-label">Enter
															name of food </label>
														<div class="col-lg-8">
															<input type="text" class="form-control" id="foodName"
																ng-model="foodName">
														</div>
													</div>
													<div class="form-group">
														<label for="foodGroup" class="col-lg-4 control-label">Select
															a group for this food item</label>
														<div class="col-lg-8">
															<select class="form-control" name='foodGroup'
																id="foodGroup" ng-model="foodGroup">
																<option value='Dairy and Egg Products'>Dairy
																	and Egg Products</option>
																<option value='Spices and Herbs'>Spices and
																	Herbs</option>
																<option value='Baby Foods'>Baby Foods</option>
																<option value='Fats and Oils'>Fats and Oils</option>
																<option value='Poultry Products'>Poultry
																	Products</option>
																<option value='Soups, Sauces, and Gravies'>Soups,
																	Sauces, and Gravies</option>
																<option value='Sausages and Luncheon Meats'>Sausages
																	and Luncheon Meats</option>
																<option value='Breakfast Cereals'>Breakfast
																	Cereals</option>
																<option value='Fruits and Fruit Juices'>Fruits
																	and Fruit Juices</option>
																<option value='Pork Products'>Pork Products</option>
																<option value='Vegetables and Vegetable Products'>Vegetables
																	and Vegetable Products</option>
																<option value='Nut and Seed Products'>Nut and
																	Seed Products</option>
																<option value='Beef Products'>Beef Products</option>
																<option value='Beverages'>Beverages</option>
																<option value='Finfish and Shellfish Products'>Finfish
																	and Shellfish Products</option>
																<option value='Legumes and Legume Products'>Legumes
																	and Legume Products</option>
																<option value='Lamb, Veal, and Game Products'>Lamb,
																	Veal, and Game Products</option>
																<option value='Baked Products'>Baked Products</option>
																<option value='Sweets'>Sweets</option>
																<option value='Cereal Grains and Pasta'>Cereal
																	Grains and Pasta</option>
																<option value='Fast Foods'>Fast Foods</option>
																<option value='Meals, Entrees, and Sidedishes'>Meals,
																	Entrees, and Sidedishes</option>
																<option value='Snacks'>Snacks</option>
																<option value='American Indian/Alaska Native Foods'>American
																	Indian/Alaska Native Foods</option>
																<option value='Restaurant Foods'>Restaurant
																	Foods</option>
															</select>
														</div>
													</div>


													<div class="row">
														<div
															class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
															<button type="submit" class="btn btn-primary"
																ng-click="searchFoodByName()">Search</button>
														</div>
													</div>
												</form>

												<div>
													<ul>
        												<li ng-repeat="item in foodOptions track by item.ndbno" ng-class="{active:($parent.selected == $index)}" 
         													 ng-click="$parent.selected = $index; printSelection();">
           													{{item.name}}
        												</li>
    												</ul>
												</div>



											</div>
										</div>
										<div id="tab-2" class="tab-pane row fade">
											<div class="col-md-12">
												<p>Activity interface will be provided here</p>
											</div>
										</div>
									</div>
								</div>
								<!-- END TABS -->

							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>