package astralplane.spell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import astralplane.spell.model.SpellModel;

public interface SpellRepository extends JpaRepository<SpellModel, Integer>, SpellRepositoryCustom{

}
