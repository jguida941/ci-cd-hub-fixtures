from monofail import get_type

def test_type_WILL_FAIL():
    assert get_type() == "monorepo-python"  # Will fail
