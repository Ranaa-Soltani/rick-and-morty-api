# README - Épreuve 3 

## Introduction

Dans cette épreuve, l'objectif était de réorganiser le code du projet Android en suivant les bonnes pratiques de Clean Architecture, d'ajouter des Managers pour certaines fonctionnalités, de bien commenter le code et de respecter les conventions de nommage.

Le projet est basé sur **Kotlin Multiplatform** et utilise **Clean Architecture** pour une séparation claire des préoccupations. Cette architecture comprend trois couches principales : Domain, Data et Presentation.

## Architecture du Projet

Le projet suit les principes de **Clean Architecture** pour séparer les préoccupations entre la logique métier, l'accès aux données et l'interface utilisateur. Il est divisé en trois couches principales : **Domain**, **Data**, et **Presentation**.

### 1. **Domain Layer (Couche Domaine)**

La couche **Domain** contient la logique métier et est indépendante des autres couches. Elle définit des modèles de données et des interfaces de repository.

### 2. **Data Layer (Couche Données)**

La couche **Data** implémente les interfaces de la couche **Domain** pour interagir avec les données provenant de différentes sources (base de données, API).

### 3. **Presentation Layer (Couche Présentation)**

La couche **Presentation** gère l'interface utilisateur en utilisant **Jetpack Compose** et les ViewModels pour préparer les données pour l'affichage.

## Utilisation des Managers

Les Managers sont utilisés pour gérer des fonctionnalités spécifiques de manière centralisée. Par exemple, dans ce projet, un **Manager Singleton** est utilisé pour gérer les sons dans l'application.

### Exemple de SoundPlayer Manager :

```kotlin
object SoundPlayer {
    private var player: MediaPlayer? = null

    fun playClickSound() {
        if (player == null) {
            val context = CleanRmApiApplication.instance.applicationContext
            player = MediaPlayer.create(context, R.raw.click_sound)
        }
        player?.start()
    }

    fun stopSound() {
        player?.stop()
        player?.release()
        player = null
    }
}
