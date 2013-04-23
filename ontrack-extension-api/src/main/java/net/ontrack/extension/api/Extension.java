package net.ontrack.extension.api;

import net.ontrack.extension.api.action.ActionExtension;
import net.ontrack.extension.api.configuration.ConfigurationExtension;
import net.ontrack.extension.api.decorator.EntityDecorator;
import net.ontrack.extension.api.property.PropertyExtensionDescriptor;

import java.util.Collection;
import java.util.List;

public interface Extension {

    String getName();

    List<? extends PropertyExtensionDescriptor> getPropertyExtensionDescriptors();

    List<? extends ConfigurationExtension> getConfigurationExtensions();

    Collection<? extends ActionExtension> getTopLevelActions();

    Collection<? extends ActionExtension> getDiffActions();

    Collection<? extends EntityDecorator> getDecorators();
}
