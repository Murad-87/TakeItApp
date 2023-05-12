package com.mytakeitapp.feature_add_publication.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.mytakeitapp.feature_api.FeatureApi

object InternalAddPublicationApi: FeatureApi {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = "", route = "") {

        }
    }
}