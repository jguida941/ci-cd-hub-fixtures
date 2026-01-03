from monopass import get_type

def test_type():
    assert get_type() == "monorepo-python"
