[subversion]

extension.svn
    en -> Subversion

subversion.configuration
    en -> Subversion repository
    fr -> Repository Subversion

subversion.configuration.create
    en -> New Subversion repository
    fr -> Nouveau repository Subversion

subversion.configuration.delete
    en -> Subversion repository deletion
    fr -> Suppression d'un repository Subversion

subversion.configuration.delete.prompt
    en -> Do you want to delete this Subversion repository?
    fr -> Voulez-vous supprimer ce repository Subversion ?

subversion.configuration.delete.prompt.promptWithProjects
    en -> ...
        @[subversion.configuration.delete.prompt] Elements listed below are associated
        with this repository and won't have access to it any longer. This
        may cause problems when working those elements.
        ...
    fr -> ...
        @[subversion.configuration.delete.prompt] Les éléments listés ci-dessous sont associés
        à ce repository et n'y auront plus accès. Cela pourrait causer
        des problèmes quand vous essayer de travailler avec ces éléments.
        ...

subversion.configuration.name
    en,fr -> @[model.name]

subversion.configuration.url
    en -> Subversion URL
    fr -> URL Subversion

subversion.configuration.user
    en -> Subversion user
    fr -> Utilisateur Subversion

subversion.configuration.password
    en -> Subversion password
    fr -> Mot de passe Subversion

subversion.configuration.branchPattern
    en -> Branch pattern
    fr -> Expression régulière pour les branches

subversion.configuration.tagPattern
    en -> Tag pattern
    fr -> Expression régulière pour les tags

subversion.configuration.tagFilterPattern
    en -> Tag filter pattern
    fr -> Expression régulière pour les tags à exclure

subversion.configuration.browserForPath
    en -> URL for browsing a path (*)
    fr -> URL pour la navigation vers un chemin (*)

subversion.configuration.browserForRevision
    en -> URL for browsing a revision (*)
    fr -> URL pour la navigation vers une révision (*)

subversion.configuration.browserForChange
    en -> URL for browsing a change set ($) for a path (*)
    fr -> URL pour la navigation pour un changement ($) vers un chemin (*)

subversion.configuration.indexationInterval
    en -> Minutes between scans (0 to disable)
    fr -> Nombre de minutes entre les indexations (0 pour désactiver)

subversion.configuration.indexationStart
    en -> Start revision
    fr -> Révision de départ

subversion.configuration.issueServiceName
    en -> Issue service
    fr -> Service de tickets

subversion.configuration.issueServiceConfigId
    en -> Issue service configuration
    fr -> Configuration pour les tickets

[repository]

subversion.repository
    en -> SVN repository
    fr -> Repository SVN

subversion.repository.description
    en -> SVN repository to use for this project
    fr -> Repository SVN à utiliser pour ce projet

[path]

subversion.path
    en -> Subversion path
    fr -> Chemin Subversion

subversion.path.description
    en -> Relative path of the branch in the SVN repository
    fr -> Chemin relatif de la branche dans le repository SVN

[buildpath]

subversion.buildPath
    en -> Subversion build path
    fr -> Chemin Subversion pour les builds

subversion.buildPath.description
    en -> ...
        Path relative to the SVN root, that contains a * that will be
        replaced by the build name in order to get the path to the
        corresponding SVN tag.
        ...
    fr -> ...
        Chemin relatif à la racine SVN, qui contient un * qui sera
        remplacé par le nom du build afin d'obtenir le chemin vers
        le tag SVN correspondant.
        ...

[indexation]

subversion.indexation.message
    en -> Indexation on {5} is {0} ({1} to {2} - at {3} - {4}%)
    fr -> Indexation de {5} {0} (de {1} à {2} - à {3} - {4}%)
subversion.indexation.running
    en -> running
    fr -> en cours
subversion.indexation.pending
    en -> pending
    fr -> en attente

subversion.indexation
    en -> Indexation
    fr -> Indexation

subversion.indexation.latest
    en -> Index
    fr -> Indexer

subversion.indexation.latest.button
    en -> Index
    fr -> Indexer

subversion.indexation.latest.message
    en -> Click on the following button to launch an indexation from the latest indexed revision.
    fr -> Cliquer sur le bouton suivant pour lancer une indexation à partir de la dernière révision indexée.

subversion.indexation.range
    en -> Range re-indexation
    fr -> Indexation d'un intervalle

subversion.indexation.range.format
    en -> Range boundaries are not correct
    fr -> Les bornes de l'intervalle de ré-indexation ne sont pas correctes.

subversion.indexation.range.button
    en -> Index
    fr -> Indexer

subversion.indexation.range.message
    en -> Re-index a given range of revisions - all previous data attached to this range will be discarded.
    fr -> Re-indexer un intervalle entre révisions - toutes les données associées à ces révisions seront ré-initialisées.

subversion.indexation.range.from
    en -> From
    fr -> De

subversion.indexation.range.to
    en -> to
    fr -> à

subversion.indexation.full
    en -> Full re-indexation
    fr -> Re-indexation complète

subversion.indexation.full.button
    en,fr -> @[subversion.indexation.full]

subversion.indexation.full.message
    en -> Click on the following button to launch a full re-indexation of the repository.
    fr -> Cliquer sur le bouton suivant lance une re-indexation complète du repository.

subversion.indexation.full.warning
    en -> Warning: you will lose all previously indexed data!
    fr -> Attention : vous perdrez toute donnée déjà indexée !

subversion.indexation.full.confirmation
    en -> Are you sure to fully re-index the repository? All associated cached data (revisions, issues...) will be lost.
    fr -> Etes-vous sûr de complètement ré-indexer le repository ? Toutes les données associées (révisions, tickets, ...) seront perdues.

subversion.indexation.alreadyrunning
    en -> An indexation is already running
    fr -> Une opération d'indexation est déjà en cours

subversion.indexation.last
    en -> Last scanned revision
    fr -> Dernière révision scannée

subversion.indexation.last.revision
    en -> Last revision
    fr -> Dernière révision

subversion.indexation.last.message
    en -> Last message
    fr -> Dernier message

subversion.indexation.last.repositoryRevision
    en -> Last revision in repository
    fr -> Dernière révision dans le repository

subversion.indexation.last.none
    en -> None
    fr -> Aucune

[errors]

net.ontrack.extension.svn.RevisionNotFoundException
    en -> Revision {0} cannot be found.
    fr -> La révision {0} ne peut pas être trouvée.

net.ontrack.extension.svn.service.SubversionException
    en -> Error while accessing Subversion: {0}
    fr -> Erreur lors de l'accès à Subversion : {0}
