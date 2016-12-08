<div ng-app="mainApp">
	<div ng-controller="analyticsController">
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
							<li><a href="#/loginPage" ng-click="logOut()">Log Out</a></li>
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
						<h1>Analytics</h1>
						<div class="content-page">
							<div class="filter-v1">
								<ul class="mix-filter">
									<div class="col-md-10 tab-style-1">
									<ul ng-init="tab = 1" class="nav nav-tabs">
										<li class="active"><a data-toggle="tab" href ng-click="tab = 1">Food and Activity History</a></li>
										<li class=""><a data-toggle="tab" href ng-click="tab = 2">Weight History</a></li>
									</ul>
									<div class="tab-content">
										<div id="tab-1" class="tab-pane active" ng-show="tab===1">
											<div class="col-md-12">
												<p>
													You are viewing food consumption and activity information for <strong>{{todaysDate}}</strong>. You can also select a different date below.
												</p>
												<table>
													<tr>
														<td>Day <select class="form-control"
															name='analytics_date_day'
															id="analytics_date_day"
															ng-model="analytics_date_day"
															ng-init="initDatePicker()">
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
															id="analytics_date_month"
															ng-model="analytics_date_month">
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
															id="analytics_date_year"
															ng-model="analytics_date_year">
																<option value='2016'>2016</option>
																<option value='2017'>2017</option>
														</select></td>
														<td><div
															class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
															<button type="submit" class="btn btn-primary"
																ng-click="getFoodAndActivityForDate()">Change Date</button>
														</div></td>
													</tr>
												</table>
												
												<div>
														<table class="table table-hover">
														<thead>
																<tr>
																	<th>Food Name</th>
																	<th>Amount</th>
																	<th>Unit</th>
																	<th>Energy Consumed</th>
																	<th><p></p></th>
																</tr>
														</thead>
														<tbody>
																<tr
																	ng-repeat="item in foodHistory track by $index" ng-click="selectItem($index)" >
																	<td ng-model="selectedFoodEntry">
																				{{item.name}}</td>
																	<td>{{item.amount}}</td>
																	<td>{{item.unit}}</td>
																	<td>{{item.calorie}}</td>
																	<td>kcal</td>
																</tr>
																<tr class="warning">
																	<td> TOTAL CONSUMED: </td>
																	<td><p></p></td>
																	<td><p></p></td>
																	<td>{{totalCalorieConsumed}}</td>
																	<td>kcal</td>
																</tr>
															</tbody>
														</table>
														
														<table class="table">
														<thead>
																<tr>
																	<th>Activity Name</th>
																	<th>Hours</th>
																	<th>Energy Burned</th>
																	<th><p></p></th>
																</tr>
														</thead>
														<tbody>
																<tr
																	ng-repeat="activityItem in activityHistory track by $index" >
																	<td>
																				{{activityItem.activityName}}</td>
																	<td>{{activityItem.hours}}</td>
																	<td>{{activityItem.calorieBurn}}</td>
																	<td>kcal</td>
																</tr>
																<tr class="success">
																	<td> TOTAL BURNED: </td>
																	<td><p></p></td>
																	<td>{{totalCalorieBurned}}</td>
																	<td>kcal</td>
																</tr>
															</tbody>
														</table>
														
		
													</div>
												
											</div>
										</div>
										<div id="tab-2" class="tab-pane active" ng-show="tab===2">
											<div class="col-md-12">
												<p>
													Weight History
												</p>
												
											</div>
										</div>
									</div>
								</div>
								</ul>
								
							</div>
						</div>
					</div>
					<!-- END CONTENT -->
				</div>
				<!-- BEGIN SIDEBAR & CONTENT -->
			</div>
		</div>
	</div>
</div>