package com.example.feature_home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.mytakeitapp.feature_api.FeatureApi

interface HomeApi: FeatureApi {

}

class HomeApiImpl: HomeApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalHomeApi.registerGraph(
            navController, navGraphBuilder
        )
    }

}